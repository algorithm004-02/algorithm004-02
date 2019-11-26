class LeetCode_714_487{

    /**
     * 714
     * <p>
     * 买卖股票的最佳时机含手续费
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices, int fee) {
        if (prices.length <= 1) {
            return 0;
        }

        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[0][0] = 0;
                dp[0][1] = -prices[0];
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }
}