package com.study.week3.lesson10;

/**
 * @Auther: 482-李国栋
 * @Date: 2019/10/30
 * @link
 */
public class LeetCode_122_482 {
    /**
     * 如果后一天的股票价格大于前一天，则买进，否则就直接卖出
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int profit=0;
        for (int i = 1; i < prices.length; i++) {
            int tmp=prices[i]-prices[i-1];
            if (tmp > 0)
                profit+=tmp;
        }
        return profit;
    }
}
