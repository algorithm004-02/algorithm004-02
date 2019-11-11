package leetcode

import "math"

// Time: O(n), Space: O(n)
func jump(nums []int) int {
	if nums == nil || len(nums) == 0 {
		return -1 // 处理边界
	}
	n, max := len(nums), 0   // 定义max最远可以跳到的下标
	d := make([]int, n)      // 定义辅助数组，表示可以跳到每个下标的最小跳数
	for i := 0; i < n; i++ { // 遍历数组
		if max >= n-1 { // 最远可达下标已经大于等于最后位置n-1
			return d[n-1] // 返回最后位置对应的最小跳数
		}
		if i > max { // 若当前下标超出了最远可达下标
			return -1 // 说明无法到达数组最后位置返回-1
		} // 若不是上面两种情况更新max
		max = int(math.Max(float64(max), float64(i+nums[i])))
		// 并在max和n-1之间求较小值，表示填充数组的最后下标
		last := int(math.Min(float64(max), float64(n-1)))
		// 填充数组d中i到last的非0元素，表示到达相应下标所需最小跳数
		for j := last; j > i && d[j] == 0; j-- {
			d[j] = d[i] + 1 // 为当前跳数d[i]加1
		}
	}
	return -1 // 循环结束后还没有提前返回，就返回-1
}

// Time: O(n), Space: O(1)
func jumpToLast(nums []int) int {
	if nums == nil || len(nums) == 0 {
		return -1
	}
	if len(nums) == 1 { // 当数组长度为1时直接返回0
		return 0 // 在数组最后位置不需要跳
	} // jumps:记录所需跳数 curEnd:使用当前跳数可以跳到的右边界
	n, max, jumps, curEnd := len(nums), 0, 0, 0
	for i := 0; i < n; i++ {
		if max >= n-1 { // 返回当前跳数+1
			return jumps + 1
		} // 表示在当前跳数基础上再跳一次到达最后位置
		if i > max {
			return -1
		}
		if i > curEnd { // 判断当前下标i是否超出了当前跳数所能到达的最右边界
			jumps++      // 如果是则跳数+1
			curEnd = max // 并且用max更新最右边界
		}
		max = int(math.Max(float64(max), float64(i+nums[i])))
	}
	return -1
}
