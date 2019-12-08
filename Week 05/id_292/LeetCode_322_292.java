  /**
     * https://leetcode-cn.com/problems/coin-change/
     * 322 .零钱兑换
     *
     * @param coins 硬币数组
     * @param amount 总额
     * @return 组合最小个数
     */

    public int coinChange(int[] coins, int amount) {

        int max = amount + 1;

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 0; i <= amount; i++) {

            for (int j = 0; j < coins.length; j++) {

                if (coins[j] <= i) {

                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];

    }