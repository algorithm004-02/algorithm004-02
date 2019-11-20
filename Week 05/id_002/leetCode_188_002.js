/**
 * @param {number} k
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(K, prices) {
    let len = prices.length;

    if (len === 0) return 0;
     

    let dp = Array.from(Array(K + 1), empty => [0, 0]);
    for (let k = 0; k <= K; k ++) {
        if (k === 0) {
            dp[0] = [0, -prices[0]];
        } else {
            dp[k] = [-Number.POSITIVE_INFINITY, -Number.POSITIVE_INFINITY];
        }
    }

    for (let i = 1; i < len; i ++) {
        for(let k = K; k >= 0; k--) {
            if (k === 0) {
                dp[k][0] = dp[k][0];
                dp[k][1] = Math.max(dp[k][1], dp[k][0] - prices[i]);
            }
            
            if (k > 0) {
                dp[k][0] = Math.max(dp[k][0], dp[k - 1][1] + prices[i]);
                dp[k][1] = Math.max(dp[k][1], dp[k][0] - prices[i]);
            }
        }
    }
    
    return dp[K][0];
};
