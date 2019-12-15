/**
 * 买卖股票的最佳时机 II
 * Created by yangwenwei on 2019/10/29.
 */
public class LeetCode_122_597 {
    class Solution {

        //贪心算法
        public int maxProfit(int[] prices) {
            int maxProfit = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1])
                    maxProfit += prices[i] - prices[i - 1];
            }
            return maxProfit;
        }
    }
}
