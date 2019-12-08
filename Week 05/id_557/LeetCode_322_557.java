//You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1. 
//
// Example 1: 
//
// 
//Input: coins = [1, 2, 5], amount = 11
//Output: 3 
//Explanation: 11 = 5 + 5 + 1 
//
// Example 2: 
//
// 
//Input: coins = [2], amount = 3
//Output: -1
// 
//
// Note: 
//You may assume that you have an infinite number of each kind of coin. 
// Related Topics Dynamic Programming


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int coinChange(int[] coins, int amount) {
        //动态规划
        //子问题：选择1,2,5
        //状态空间：dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
        //状态转移方程
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        //注意for loop的顺序，如果改变内外循环会影响速度
        for (int j = 0; j < coins.length; j++) {
            for (int i = 1; i <= amount; i++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

//    public int coinChange(int[] coins, int amount) {
//        if(coins == null)
//            return 0;
//        //此处必须定义为long，不然会出现溢出
//        long[] dp = new long[amount+1];
//        Arrays.fill(dp, Integer.MAX_VALUE);
//        dp[0]=0;
//        for(int i=0; i<coins.length; i++){
//            for(int amt=1; amt<dp.length; amt++){
//                if(amt-coins[i]>=0)
//                    dp[amt] = Math.min(dp[amt],dp[amt-coins[i]]+1);
//            }
//        }
//        return dp[amount] == Integer.MAX_VALUE ? -1 : (int) dp[amount];
//    }

}
//leetcode submit region end(Prohibit modification and deletion)
