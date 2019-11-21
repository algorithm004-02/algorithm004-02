/** 188. 买卖股票的最佳时机 IV */

/** 
DP: (188 最多k笔交易)
    a. 重复子问题
        for k range(K) :
            k === 0
            maxPro[i][0][0] = maxPro[i - 1][0][0]
            maxPro[i][0][1] = Math.max(maxPro[i - 1][0][1], maxPro[i - 1][0][0] - prices[i])
            k > 0
            maxPro[i][1][0] = Math.max(maxPro[i - 1][1][0], maxPro[i - 1][0][1] + prices[i])
            maxPro[i][1][1] = Math.max(maxPro[i - 1][1][1], maxPro[i - 1][1][0] - prices[i])

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
        for k Range(k) :
            k === 0
            f[i][0][0] = f[i - 1][0][0]
            f[i][0][1] = Max(f[i - 1][0][1], f[i - 1][0][0] - prices[i])

            k > 0
            f[i][k][0] = Max(f[i - 1][k][0], f[i - 1][k - 1][1] + prices[i])
            f[i][k][1] = Max(f[i - 1][k][1], f[i - 1][k][0] - prices[i])
**/


/**
 * 超出时间限制
 * @param {number} k
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(K, prices) {
    let dp = [];
    let len = prices.length;

    if (len === 0) return 0;
    
    dp[0] = Array(K + 1).map(() => []);
    for (let k = 0; k <= K; k ++) {
       dp[0][k] =[];
       if (k === 0) {
           dp[0][0] = [0, -prices[0]];
           continue;
       }
       
       dp[0][k] = [-Number.POSITIVE_INFINITY, -Number.POSITIVE_INFINITY];
    }

    for(let i = 1; i < len; i ++) {
        dp[i] = Array(K).map(() => []);
        for (let k = 0; k <= K; k ++) {
            dp[i][k] = [];
            if (k === 0) {
                dp[i][k][0] = dp[i - 1][k][0];
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k][0] - prices[i]);
                continue;
            }

            dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k - 1][1] + prices[i]);
            dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k][0] - prices[i]);
        }
    }

    return Math.max(...dp[len - 1].map(p => p[0]));   
};

/**
 * 超出内存
 * @param {number} k
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit2 = function(K, prices) { 
    let len = prices.length;
    if (len === 0) return 0;

    let max = 0;
    
    let dp = Array.from(Array(prices.length), emty => Array.from(Array(K + 1), empty => [0, 0]));
    for(let i = 0; i < len; i ++) {
        for (let k = 0; k <= K; k ++) {
            if (i === 0 || k ===0) {
                if (k === 0) {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = - prices[i];
                } else {
                    dp[i][k][0] = - Number.POSITIVE_INFINITY;
                    dp[i][k][1] = - Number.POSITIVE_INFINITY;
                }
                
                continue;
            }

            dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k - 1][1] + prices[i]);
            dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k][0] - prices[i]);

            max = Math.max(max, dp[i][k][0])
        }
    }
    
    return max; 
};

