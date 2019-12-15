/*
 * @lc app=leetcode.cn id=198 lang=golang
 *
 * [198] 打家劫舍
 */

// @lc code=start
func rob(nums []int) int {
	if len(nums) == 0 {
		return 0
	}
	if len(nums) == 1 {
		return nums[0]
	}
	dp := make([]int, len(nums)+1)
	dp[1] = nums[0]
	for i := 2; i <= len(nums); i++ {
		dp[i] = compmax(dp[i-2]+nums[i-1], dp[i-1])
	}
	return dp[len(nums)]
}

func compmax(a, b int) int {
	if a >= b {
		return a
	}
	return b
}

// @lc code=end
