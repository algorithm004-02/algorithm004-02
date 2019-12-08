package com.itliusir.dynamic;

/**
 * problem.123
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 N 笔 交易。
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,3,5,0,0,3,1,4]
 * 输出: 6
 * 解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 *      随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。  
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。  
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3:
 * <p>
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。
 *
 * @author liugang
 * @since 2019/11/17
 */
public class StockMore {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int num = 1;
        System.out.println(new StockMore().maxProfit(prices, num));
    }

    public int maxProfit(int[] prices, int num) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int[][][] mp = new int[prices.length][2][num + 1];
        for (int i = 0; i < num; i++) {
            // 第一天买入卖出num次后不再买入
            mp[0][0][i] = 0;
            // 第一天买入卖出num次后又买入
            mp[0][1][i] = -prices[0];
        }
        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j <= num; j++) {
                // 不持有股票，当日卖出 vs 不动
                mp[i][0][j] = j != 0 ? Math.max(mp[i - 1][1][j - 1] + prices[i], mp[i - 1][0][j]) : mp[i - 1][0][j];
                // 持有股票，当日买入 vs 不动
                mp[i][1][j] = Math.max(mp[i - 1][0][j] - prices[i], mp[i - 1][1][j]);
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= num; i++) {
            max = Math.max(max, mp[prices.length - 1][0][i]);
        }
        return max;
    }
}
