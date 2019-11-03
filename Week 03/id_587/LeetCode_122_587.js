/*
 * @lc app=leetcode.cn id=122 lang=javascript
 *
 * [122] 买卖股票的最佳时机 II
 */
// @lc code=start
/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function (prices) {
    var result = 0;
    for (var index = 0; index < prices.length - 1; index++) {
        if (prices[index] < prices[index + 1]) {
            result += prices[index + 1] - prices[index];
        }
    }
    return result;
};
// @lc code=end
