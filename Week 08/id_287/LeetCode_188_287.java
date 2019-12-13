package com.tulane.leetcode.one;

/**
 * Created by Tulane
 * 2019/12/8
 */
public class LeetCode_188 {

    public int maxProfit(int k, int[] prices) {
        if (k > (prices.length / 2)) {
            return maxProfitAnyK(prices);
        }
        if (prices.length == 0) return 0;
        int[][][] dp = new int[prices.length][k + 1][2];
        for (int i = 0; i < prices.length; i++) {
            for (int t = 1; t < k + 1; t++) {
                if (i - 1 == -1) {
                    dp[i][t][0] = 0;
                    dp[i][t][1] = -prices[i];
                    continue;
                }
                dp[i][t][0] = Math.max(dp[i - 1][t][0], dp[i - 1][t][1] + prices[i]);
                dp[i][t][1] = Math.max(dp[i - 1][t][1], dp[i - 1][t - 1][0] - prices[i]);
            }
        }
        return dp[prices.length - 1][k][0];
    }

    private int maxProfitAnyK(int[] prices){
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int price : prices) {
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + price);
            dp_i_1 = Math.max(dp_i_1, dp_i_0 - price);
        }
        return dp_i_0;
    }
}
