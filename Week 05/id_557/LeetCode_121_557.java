//Say you have an array for which the ith element is the price of a given stock on day i. 
//
// If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit. 
//
// Note that you cannot sell a stock before you buy one. 
//
// Example 1: 
//
// 
//Input: [7,1,5,3,6,4]
//Output: 5
//Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
//             Not 7-1 = 6, as selling price needs to be larger than buying price.
// 
//
// Example 2: 
//
// 
//Input: [7,6,4,3,1]
//Output: 0
//Explanation: In this case, no transaction is done, i.e. max profit = 0.
// 
// Related Topics Array Dynamic Programming


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {

        //一个方法团灭6道股票题目的套路方法
        //动态规划：Dp table

        //股票的天数
        int n = prices.length;
        if (n == 0 || n == 1) return 0;
        int dp_i_0 = 0; //第i天持没有持有股票获得的最大利润
        int dp_i_1 = -prices[0];// 第i天持有股票获得的最大利润
        for (int i = 1; i < n; i++) {
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);//前一天也未持有股票的最大利润和前一天持有股票但是当天卖出中的较大者
            dp_i_1 = Math.max(dp_i_1, -prices[i]);//前一天持有股票和前一天未持有股票当天买入（因为只有一次交易，所以结果为-prices[i]）
        }
        return dp_i_0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
