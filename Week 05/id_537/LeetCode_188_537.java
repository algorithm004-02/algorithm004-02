package leetcode.editor.cn;

//给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
//
// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。 
//
// 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 示例 1: 
//
// 输入: [2,4,1], k = 2
//输出: 2
//解释: 在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
// 
//
// 示例 2: 
//
// 输入: [3,2,6,5,0,3], k = 2
//输出: 7
//解释: 在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
//     随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
// 
// Related Topics 动态规划
public class LeetCode_188_537 {

    public static void main(String[] args) {
        Solution solution = new LeetCode_188_537().new Solution();
    }

    private

//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int k, int[] prices) {

//            if (prices == null || prices.length < 1 || k < 1) {
//                return 0;
//            }
//            if (k > prices.length >> 1) {
//                return maxProfit(prices);
//            }
//            // 初始化 dp 数组,第 i 天，第 k 笔 交易，是否持有股票,1 持有，0 不持有
//            int[][][] mp = new int[prices.length][k + 1][2];
//            // 初始化第一天数据，买入股票
//            for (int i = 1; i < k+1; i++) {
//                mp[0][i][1] = -prices[0];
//            }
//            // 依次递归最大收益
//            for (int i = 1; i < prices.length; i++) {
//                for (int j = 1; j <= k; j++) {
//                    // 第 i 天，第 j 笔 交易，不持有股票的最大值=
//                    // 前一天持有股票今天卖出 / 前一天不持有股票，保持不变
//                    mp[i][j][0] = Math.max(mp[i - 1][j][0], mp[i - 1][j][1] + prices[i]);
//                    // 第 i 天，第 j 笔 交易，持有股票的最大值=
//                    // 前一天不持有股票今天买入 / 前一天持有股票，保持不变
//                    mp[i][j][1] = Math.max(mp[i - 1][j][1], mp[i - 1][j - 1][0] - prices[i]);
//                }
//            }
//            return mp[prices.length - 1][k][0]; // 最大利润



            if (k <= 0 || prices == null || prices.length < 2) {
                return 0;
            }
            if (k > prices.length / 2) {
                return maxProfit(prices);
            }
            int[][] dp = new int[k + 1][2];
            for (int i = 0; i < k + 1; i++) {
                dp[i][1] = -prices[0];
            }
            int max = 0;
            for (int i = 1; i < prices.length; i++) {
                for (int j = 1; j < Math.min(k + 1,i/2+2); j++) {
                    dp[j][1] = Math.max(dp[j - 1][0] - prices[i], dp[j][1]);
                    dp[j][0] = Math.max(dp[j][1] + prices[i], dp[j][0]);
                    max = Math.max(dp[j][0], max);
                }
            }
            return max;
        }
        public int maxProfit(int[] prices) {
            int profit = 0;
            // 贪婪算法，存在利润就卖出
            for (int i = 0; i < prices.length-1; i++) {
                if (prices[i] < prices[i + 1]) {
                    profit += prices[i + 1] - prices[i];
                }
            }
            return profit;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}