/** 121. 买卖股票的最佳时机 **/

// DP:(1次交易)
//      a. 重复子问题
//          max_profrit[i][0] = Max(max_profrit[i - 1][1] + prices[i], max_profrit[i - 1][0])
//          max_profrit[i][1] = Max(- prices[i], max_profrit[i - 1][1])
//      b. 定义状态数组
//          f[i] = [0, 1]
//              0 : 不持有股票
//              1 : 持有股票
//      c. DP方程
//          f[i][0] = Max(f[i - 1][1] + prices[i], f[i - 1][0])
//          f[i][1] = Max(- prices[i], f[i - 1][1])

/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
    if (prices.length === 0) return 0;
    
    let dp = [];
    dp[0] = [0, -prices[0]];
   
    for(let i = 1; i < prices.length; i ++) {
        dp[i] = [];
        dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);
        dp[i][1] = Math.max(- prices[i], dp[i - 1][1]);
    }

    return dp[prices.length - 1][0];
};