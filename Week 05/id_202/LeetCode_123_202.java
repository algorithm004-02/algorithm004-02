package com.algorithm.qinchao.homework.week05;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/11/16 15:40
 * @description 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 示例 1:
 * 输入: [3,3,5,0,0,3,1,4]
 * 输出: 6
 * 解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 *      随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 * 示例 2:
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。  
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。  
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3:
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_123_202 {
    /**
     * dp方程：dp[i][k][0] = max(dp[i-1][k][0],dp[i-1][k][1]+price[i])
     * dp[i][k][1] = max(dp[i-1][k][1],dp[i-1][k-1][0]-price[i])
     * k=2,最大两次交易，可以是一次，或者两次，或者不交易，需要遍历k
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int maxk = 2;
        int length = prices.length;
        int[][][] status = new int[length][maxk + 1][2];
        for (int i = 0; i < length; i++) {
            for (int k = maxk; k >= 1; k--) {
                if (i - 1 < 0) {
                    status[i][k][0] = 0;
                    status[i][k][1] = -prices[i];
                    continue;
                }
                status[i][k][0] = Math.max(status[i - 1][k][0], status[i - 1][k][1] + prices[i]);
                status[i][k][1] = Math.max(status[i - 1][k][1], status[i - 1][k - 1][0] - prices[i]);
            }
        }
        return Math.max(status[length - 1][maxk][0], status[length - 1][maxk][1]);
    }

    public static void main(String[] args) {
        int[] prices = new int[]{3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(LeetCode_123_202.maxProfit(prices));
    }
}
