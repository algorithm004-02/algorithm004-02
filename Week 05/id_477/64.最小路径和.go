package leetcode

import "fmt"

/*
 * @lc app=leetcode.cn id=64 lang=golang
 *
 * [64] 最小路径和
 */

// @lc code=start
func minPathSum(grid [][]int) int {
	if len(grid) == 0 {
		return 0
	}
	m, n := len(grid), len(grid[0])
	// subproblem
	// dp array
	dp := grid
	// dp  dp[i][j] = min(dp[i][j+1], dp[i-1][j]) + grid[i][j]
	for i := m - 1; i >= 0; i-- {
		for j := n - 1; j >= 0; j-- {
			var min, v1, v2 = 0, -1, -1
			if i+1 < m {
				v1 = grid[i+1][j]
			}
			if j+1 < n {
				v2 = grid[i][j+1]
			}
			if v1 < 0 && v2 < 0 {
				min = 0
			} else if v1 < 0 {
				min = v2
			} else if v2 < 0 {
				min = v1
			} else if v1 < v2 {
				min = v1
			} else {
				min = v2
			}
			dp[i][j] = grid[i][j] + min
		}
	}
	return dp[0][0]
}

// @lc code=end
