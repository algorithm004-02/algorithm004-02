package com.tulane.leetcode.one;

/**
 * Created by Tulane
 * 2019/12/8
 */
public class LeetCode_714 {

    public int maxProfit(int[] prices, int fee) {
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int price : prices) {
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + price);
            dp_i_1 = Math.max(dp_i_1, dp_i_0 - price - fee);
        }
        return dp_i_0;
    }
}
