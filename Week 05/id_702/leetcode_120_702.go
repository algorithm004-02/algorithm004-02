package leetcode

/*
 * @lc app=leetcode.cn id=120 lang=golang
 *
 * [120] 三角形最小路径和
 */

// @lc code=start
func comp(a, b int) int {
	if a <= b {
		return a
	}
	return b
}

func minimumTotal(triangle [][]int) int {
	if len(triangle) == 0 {
		return 0
	}

	dp := triangle[len(triangle)-1]
	for i := len(triangle) - 2; i >= 0; i-- {
		for j := 0; j <= i; j++ {
			dp[j] = comp(dp[j], dp[j+1]) + triangle[i][j]
		}
	}
	return dp[0]
}

// @lc code=end
