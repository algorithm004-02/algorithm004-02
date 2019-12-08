package com.algorithm.qinchao.homework.week05;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/11/16 15:55
 * @description
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 示例:
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_309_202 {
    /**
     * dp方程：dp[i][k][0] = max(dp[i-1][k][0],dp[i-1][k][1]+price[i])
     *      * dp[i][k][1] = max(dp[i-1][k][1],dp[i-1][k-1][0]-price[i])
     *      * <p>
     *      * k=无穷大,k约等于k-1
     *  dp方程：dp[i][0] = max(dp[i-1][0],dp[i-1][1]+price[i])
     *  dp[i][1] = max(dp[i-1][1],dp[i-1][0]-price[i])
     *
     *    隔一天才能买
     *
     *     dp方程：dp[i][0] = max(dp[i-1][0],dp[i-1][1]+price[i])
     *      *  dp[i][1] = max(dp[i-1][1],dp[i-2][0]-price[i])
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int dpI0 = 0;
        int dpI1 = Integer.MIN_VALUE;
        int dpPre = 0;
        int temp;
        for (int price : prices) {
            temp = dpI0;
            dpI0 = Math.max(dpI0, dpI1 + price);
            dpI1 = Math.max(dpI1, dpPre - price);
            dpPre = temp;
        }
        return Math.max(dpI0, dpI1);
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1, 2, 3, 0, 2};
        System.out.println(LeetCode_309_202.maxProfit(prices));
    }
}
