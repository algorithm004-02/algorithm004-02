class LeetCode_309_487{

    /**
     * 309.
     * <p>
     * 最佳买卖股票时机含冷冻期
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        //小于等于1,直接返回0
        if (prices.length <= 1) {
            return 0;
        }

        int n = prices.length;
        int[][] dp = new int[n][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);
        dp[1][1] = Math.max(dp[0][1], dp[0][0] - prices[1]);

        //如果等于2直接比较前后大小
        if (prices.length == 2) {
            return (prices[1] > prices[0] ? prices[1] - prices[0] : 0);
        }

        for (int i = 2; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);//冻结一天,所以是-2
        }
        return dp[n - 1][0];
    }
}