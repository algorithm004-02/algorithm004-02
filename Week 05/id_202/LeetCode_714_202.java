package com.algorithm.qinchao.homework.week05;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/11/16 16:24
 * @description 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
 * <p>
 * 你可以无限次地完成交易，但是你每次交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 * 返回获得利润的最大值。
 * 示例 1:
 * 输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
 * 输出: 8
 * 解释: 能够达到的最大利润:
 * 在此处买入 prices[0] = 1
 * 在此处卖出 prices[3] = 8
 * 在此处买入 prices[4] = 4
 * 在此处卖出 prices[5] = 9
 * 总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 * 注意:
 * 0 < prices.length <= 50000.
 * 0 < prices[i] < 50000.
 * 0 <= fee < 50000.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_714_202 {
    /**
     * dp[i][k][0] = max(dp[i-1][k][0],dp[i-1][k][1]+price[i])
     * dp[i][k][1]  = max(dp[i-1][k][1],dp[i-1][k-1][0]-price[i])
     * k=无穷大，忽略k，手续费fee
     * dp[i][0] = max(dp[i-1][0],dp[i-1][1]+price[i])
     * dp[i][1]  = max(dp[i-1][1],dp[i-1][0]-price[i]-fee)
     *
     * @param prices
     * @param fee
     * @return
     */
    public static int maxProfit(int[] prices, int fee) {
        int dpI0 = 0;
        int dpI1 = Integer.MIN_VALUE;
        int temp;
        for (int price : prices) {
            temp = dpI0;
            dpI0 = Math.max(dpI0, dpI1 + price);
            dpI1 = Math.max(dpI1, temp - price - fee);
        }
        return Math.max(dpI0, dpI1);
    }

    public static void main(String[] args) {
        System.out.println(LeetCode_714_202.maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
    }
}
