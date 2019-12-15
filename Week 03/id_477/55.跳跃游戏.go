/*
 * @lc app=leetcode.cn id=55 lang=golang
 *
 * [55] 跳跃游戏
 */

// @lc code=start
func canJump(nums []int) bool {
	if len(nums) == 0 {
		return false
	}
	end := len(nums) - 1
	for i := end; i >= 0; i-- {
		if nums[i]+i >= end {

			end = i
		}
	}
	return end == 0
}

// @lc code=end
