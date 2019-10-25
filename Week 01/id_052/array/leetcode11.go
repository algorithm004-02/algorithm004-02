package LeetCode

// 方法一：循环暴力破解，枚举left bar x, right bar y, (y-x)*左右较小的height
// 执行用时 : 728 ms, 在所有 golang 提交中击败了 9.82% 的用户
// 内存消耗 : 5.6 MB, 在所有 golang 提交中击败了 65.35% 的用户
func maxArea(height []int) int {
	area := 0 // 记录最大容量
	for i := 0; i < len(height); i++ {
		for j := i + 1; j < len(height); j++ {
			if height[i] < height[j] {
				if area < height[i]*(j-i) {
					area = height[i] * (j - i)
				}
			} else {
				if area < height[j]*(j-i) {
					area = height[j] * (j - i)
				}
			}
		}
	}
	return area
}

// 优化
func maxArea_(height []int) int {
	maxArea := 0 // 记录最大容量
	for i := 0; i < len(height)-1; i++ {
		for j := i + 1; j < len(height); j++ {
			area := (j - i) * min(height[i], height[j])
			maxArea = max(maxArea, area)
		}
	}
	return maxArea
}

// 方法二：双指针，左右边界向中间收敛，左右夹逼
// 执行用时 : 16 ms , 在所有 golang 提交中击败了 91.98% 的用户
// 内存消耗 : 5.6 MB , 在所有 golang 提交中击败了 65.35% 的用户
func maxArea2(height []int) int {
	left, right := 0, len(height)-1 // 左指针和右指针定义
	ret := 0                        // 记录最大容量
	for left < right {
		ret = max(ret, (right-left)*min(height[left], height[right]))
		if height[left] < height[right] {
			left++
		} else {
			right--
		}
	}
	return ret
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

// https://leetcode-cn.com/problems/container-with-most-water/solution/custerxue-xi-bi-ji-shuang-zhi-zhen-by-custergo-3/
