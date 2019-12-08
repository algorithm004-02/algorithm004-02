package src.main.java.com.fans.algorithm00402.week3.homework;

/**
 * 买卖股票的最佳时机2
 */
public class LeetCode_122_232 {

    /**
     * 1. 贪心 O(n) O(1)
     */
    public int maxProfit(int[] prices) {
        int count = 0;
        for (int i = 0; i < prices.length - 1; i ++) {
            if (prices[i + 1] > prices[i]) count += prices[i + 1] - prices[i];
        }
        return count;
    }

}
