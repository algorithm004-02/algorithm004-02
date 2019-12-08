package leetcode

import (
	"runtime/internal/math"
)

/*
 * @lc app=leetcode.cn id=322 lang=golang
 *
 * [322] 零钱兑换
 */

// @lc code=start
func coinChange(coins []int, amount int) int {
	dp := make([]int, amount+1)
	for i := 1; i <= amount; i++ {
		dp[i] = math.MaxInt32
		for _, v := range coins {
			if v <= i {
				dp[i] = compmin(dp[i], dp[i-v]+1)
			}
		}
	}
	if dp[amount] > amount {
		return -1
	}
	return dp[amount]
}

func compmin(a, b int) int {
	if a <= b {
		return a
	}
	return b
}

// @lc code=end
