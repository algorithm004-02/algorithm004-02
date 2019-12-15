/** 123. 买卖股票的最佳时机 III */
/** 
DP: (123 最多2笔交易)
    a. 重复子问题
        maxPro[i][0][0] = maxPro[i - 1][0][0]
        maxPro[i][0][1] = Math.max(maxPro[i - 1][0][1], maxPro[i - 1][0][0] - prices[i])

        maxPro[i][1][0] = Math.max(maxPro[i - 1][1][0], maxPro[i - 1][0][1] + prices[i])
        maxPro[i][1][1] = Math.max(maxPro[i - 1][1][1], maxPro[i - 1][1][0] - prices[i])

        maxPro[i][2][0] = Math.max(maxPro[i - 1][2][0], maxPro[i - 1][1][1] + prices[i])
    b. 定义状态数组
        f[i][k][j]
            i: 第几天
            k: 
                0： 0次交易
                1： 第一次交易
                2： 第二次交易
            j: 
                0: 没有持有股票
                1： 持有股票
    c. DP方程
        f[i][0][0] = f[i - 1][0][0]
        f[i][0][1] = Max(f[i - 1][0][1], f[i - 1][0][0] - prices[i])

        f[i][1][0] = Max(f[i - 1][1][0], f[i - 1][0][1] + prices[i])
        f[i][1][1] = Max(f[i - 1][1][1], f[i - 1][1][0] - prices[i])

        f[i][2][0] = Max(f[i - 1][2][0], f[i - 1][1][1] + prices[i])
**/

/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
    let dp = [];
    let len = prices.length;

    if (len === 0) return 0;

    dp[0] = Array(3).map(() => []);
    dp[0][0] = [0, -prices[0]];
    dp[0][1] = [-Number.POSITIVE_INFINITY, -Number.POSITIVE_INFINITY];
    dp[0][2] = [-Number.POSITIVE_INFINITY, -Number.POSITIVE_INFINITY];
 
    for(let i = 1; i < len; i ++) {
        dp[i] = Array(3).map(() => []);
        dp[i][0] = [];
        dp[i][1] = [];
        dp[i][2] = [];

        dp[i][0][0] = dp[i - 1][0][0];
        dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][0][0] - prices[i]);

        dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][0][1] + prices[i]);
        dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][1][0] - prices[i]);

        dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][1][1] + prices[i]);
    }

    return Math.max(dp[len - 1][0][0], dp[len - 1][1][0], dp[len - 1][2][0]);
};