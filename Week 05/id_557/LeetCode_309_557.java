//Say you have an array for which the ith element is the price of a given stock on day i. 
//
// Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions: 
//
// 
// You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again). 
// After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day) 
// 
//
// Example: 
//
// 
//Input: [1,2,3,0,2]
//Output: 3 
//Explanation: transactions = [buy, sell, cooldown, buy, sell]
// Related Topics Dynamic Programming


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0 || n == 1) return 0;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[1][0] = Math.max(0, -prices[0] + prices[1]);
        dp[1][1] = Math.max(-prices[0], -prices[1]);
        for (int i = 2; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
        }
        return dp[n - 1][0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
