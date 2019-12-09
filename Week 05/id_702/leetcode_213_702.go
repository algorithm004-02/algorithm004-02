/*
 * @lc app=leetcode.cn id=213 lang=golang
 *
 * [213] 打家劫舍 II
 */

// @lc code=start
func compmax(a, b int) int {
	if a >= b {
		return a
	}
	return b
}

func subrob(nums []int) int {
	l := len(nums)
	dp := make([]int, l+1)
	dp[1] = nums[0]
	for i := 2; i <= l; i++ {
		dp[i] = compmax(dp[i-2]+nums[i-1], dp[i-1])
	}
	return dp[l]
}

func rob(nums []int) int {
	l := len(nums)
	if l == 0 {
		return 0
	}
	if l == 1 {
		return nums[0]
	}
	dp1 := subrob(nums[1:])
	dp2 := subrob(nums[:l-1])
	return compmax(dp1, dp2)
}

// @lc code=end
