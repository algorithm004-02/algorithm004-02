package com.tulane.leetcode.one;

/**
 * Created by Tulane
 * 2019/12/8
 */
public class LeetCode_123 {
    public int maxProfit(int[] prices) {
        int dp_i_k1_0 = 0, dp_i_k1_1 = Integer.MIN_VALUE;
        int dp_i_k2_0 = 0, dp_i_k2_1 = Integer.MIN_VALUE;
        for (int price : prices) {
            dp_i_k1_0 = Math.max(dp_i_k1_0, dp_i_k1_1 + price);
            dp_i_k1_1 = Math.max(dp_i_k1_1, -price);
            dp_i_k2_0 = Math.max(dp_i_k2_0, dp_i_k2_1 + price);
            dp_i_k2_1 = Math.max(dp_i_k2_1, dp_i_k1_0 - price);
        }
        return dp_i_k2_0;
    }

    public int maxProfit1(int[] prices) {
        if(prices.length == 0) return 0;
        int[][][] dp = new int[prices.length][3][2];
        for (int i = 0; i < prices.length; i++) {
            for (int k = 1; k < 3; k++) {
                if(i - 1 == -1){
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }
        return dp[prices.length - 1][2][0];
    }
}
