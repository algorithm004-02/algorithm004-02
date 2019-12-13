package leetcode

/*
 * @lc app=leetcode.cn id=42 lang=golang
 *
 * [42] 接雨水
 */

// @lc code=start
func trap(height []int) int {
	sum := 0
	Lmax, Rmax := 0, 0
	for i, j := 0, len(height)-1; i < j; {
		if height[i] < height[j] {
			if height[i] > Lmax {
				Lmax = height[i]
			} else {
				sum += Lmax - height[i]
			}
			i++
		} else {
			if height[j] > Rmax {
				Rmax = height[j]
			} else {
				sum += Rmax - height[j]
			}
			j--
		}
	}
	return sum
}

// @lc code=end
