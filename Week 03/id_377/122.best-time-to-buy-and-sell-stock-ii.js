/*
 * @lc app=leetcode id=122 lang=golang
 */

// @lc code=start
// ------------------------- 解法 1 start --------------------------
// 最好记  👍 👍 👍 👍 👍
// 最优解  😘 😘 😘 😘 😘
var maxProfit = function(prices) {
    let diff = 0
    if (prices.length > 0) { // []
        prices.reduce((acc, next) => {
            if (next > acc) {
                diff += next - acc
            }
            return next
        })
    }
    return diff
};
// ------------------------- 解法 2 start --------------------------
// 最好记  👍 👍 👍 👍
// 最优解  😘 😘 😘 😘
var maxProfit = function(prices) {
    let max = 0;
    for (let i = 1; i < prices.length; i++) {
        if (prices[i] > prices[i - 1]) max += prices[i] - prices[i - 1];
    }
    return max;
}

// @lc code=end

