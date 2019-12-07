/*
 * @lc app=leetcode id=122 lang=golang
 */

// @lc code=start
// ------------------------- 解法 1 start --------------------------
// 最好记  👍 👍 👍 👍 👍
// 最优解  😘 😘 😘 😘 😘
func maxProfit(prices []int) int {
	if len(prices) == 0 {
		return 0
	}
	profit := 0
	min := prices[0]

	for _, price := range prices {
		if price > min {
			profit += price - min
		}
		min = price
	}
	return profit
}

// @lc code=end

