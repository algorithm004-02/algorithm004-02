package LeetCode

// 方法一：暴力解法 Time: O(k*n), Space: O(1)
// 每移动一个数字，比较该滑动窗口内k个数求最大值，保存到结果数组中
// 每次在滑动窗口内求最大值，需要O(k)的时间复杂度
// 滑动窗口从左向右划过数组，需要O(n)的时间复杂度
// 因此总的时间复杂度是O(n*k)，不需要额外的空间，所以空间复杂度是O(1)
func maxSlidingWindow(nums []int, k int) []int {
	if nums == nil || len(nums) == 0 {
		return nums // 处理边界，若数组为空或长度为0，原样返回数组
	}
	n := len(nums)
	result := make([]int, n-k+1)         // 大小为k的窗口划过n的数组能产生最大值的个数
	for left := 0; left <= n-k; left++ { // 窗口的左下标从0遍历到n-k
		max := nums[left]                // 滑动窗口最大值初始化为窗口最左边的值
		for i := left; i < left+k; i++ { // 遍历滑动窗口内的数字，找到窗口内的最大值
			if nums[i] > max {
				max = nums[i]
			}
		}
		result[left] = max // 把最大值加入到结果数组
	}
	return result
}

// 方法二：用长度k给数组分组，最后一组可能不足k个
// - 对每个分组先从左向右求最大值
// - 对每个分组从右向左求最大值
// - 有了这两个辅助数组，可以在O(1)的时间内求长度为k的任意滑动窗口内的最大值
// - 滑动窗口和这两组分组有两种关系
// 	- 滑动窗口跨域两个分组
// 		- 滑动窗口左右边沿两个下标对应在两个辅助数组中的两个数字，最大值就是对应滑动窗口内的最大值
// 	- 滑动窗口覆盖一个窗口
// - 需要遍历两次数组，是辅助数组的填充和结果数组的填充，所以时间复杂度是O(n)
// - 因为需要大小为n的辅助数组，所以空间复杂度也是O(n)
func maxSlidingWindow2(nums []int, k int) []int {
	if nums == nil || len(nums) == 0 {
		return nums
	}
	n := len(nums)                 // 数组长度赋值给n
	result := make([]int, n-k+1)   // 定义结果数组
	maxFromLeft := make([]int, n)  // 定义辅助数组，分别记录从左向右和从右向左的分组内
	maxFromRight := make([]int, n) // 阶段的最大值
	maxFromLeft[0] = nums[0]
	maxFromRight[n-1] = nums[n-1]
	for i, j := 1, n-2; i < n; { // 从左向右和从右向左分别计算每个长度为k的分组内阶段最大值
		if i%k == 0 { // 从左向右下标可以整除k，分组内第一个的数字
			maxFromLeft[i] = nums[i] // 阶段最大值就是它自己
		} else { // 否则比较上一个最大值和当前数字的最大值
			maxFromLeft[i] = maxValue(maxFromLeft[i-1], nums[i])
		}

		if j%k == k-1 { // 从右向左方向下标整除k-1，则说明是分组内的第一个数字
			maxFromRight[j] = nums[j] // 最大值就等于它自己
		} else { // 否则最大值就比较上一个最大值和当前数字
			maxFromRight[j] = maxValue(maxFromRight[j+1], nums[j])
		}
		i++
		j--
	}
	for i := 0; i <= n-k; i++ {
		result[i] = maxValue(maxFromRight[i], maxFromLeft[i+k-1])
	}
	return result
}

func maxValue(a, b int) int {
	if a > b {
		return a
	}
	return b
}

// 方法三：双端队列Deque
func maxSlidingWindow3(nums []int, k int) []int {
	if nums == nil || len(nums) == 0 {
		return nums
	}
	window := make([]int, 0, k) // store the index of nums
	result := make([]int, 0, len(nums)-k+1)
	for i, v := range nums { // if the left-most index is out of window, remove it
		if i >= k && window[0] <= i-k {
			window = window[1:] // 移除最左边的值
		}
		for len(window) > 0 && nums[window[len(window)-1]] < v { // maintain window
			window = window[:len(window)-1]
		}
		window = append(window, i) // store the index of nums
		if i >= k-1 {
			result = append(result, nums[window[0]]) // the left-most is the index of max value in nums
		}
	}
	return result
}

// https://leetcode-cn.com/problems/sliding-window-maximum/solution/custerxue-xi-bi-ji-hua-dong-chuang-kou-by-custer-2/
