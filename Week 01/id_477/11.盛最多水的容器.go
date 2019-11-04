package leetcode

/*
 * @lc app=leetcode.cn id=11 lang=golang
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
func maxArea(height []int) int {
	// max := 0
	// for i := 0; i < len(height)-1; i++ {
	// 	for j := i + 1; j < len(height); j++ {
	// 		if tmp := (j - i) * min(height[i], height[j]); tmp > max {
	// 			max = tmp
	// 		}
	// 	}
	// }
	// return max

	max := 0
	i, j := 0, len(height)-1
	for i < j {
		if tmp := (j - i) * min(height[i], height[j]); tmp > max {
			max = tmp
		}
		if height[i] < height[j] {
			i++
		} else {
			j--
		}
	}
	return max
}

func min(a, b int) int {
	if a > b {
		return b
	} else {
		return a
	}
}

// @lc code=end
