package leetcode.editor.cn;

import java.util.Arrays;

//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
//
// 示例 1: 
//
// 输入: coins = [1, 2, 5], amount = 11
//输出: 3 
//解释: 11 = 5 + 5 + 1 
//
// 示例 2: 
//
// 输入: coins = [2], amount = 3
//输出: -1 
//
// 说明: 
//你可以认为每种硬币的数量是无限的。 
// Related Topics 动态规划
public class LeetCode_322_537 {

    public static void main(String[] args) {
        Solution solution = new LeetCode_322_537().new Solution();
        int[] a = new int[]{120, 6, 320, 300, 100, 192, 212, 89, 106, 461};
        System.out.println(solution.coinChange(a, 8332));
    }

    private

//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int coinChange(int[] coins, int amount) {
            if (amount == 0) {
                return 0;
            }
            if (coins == null || coins.length == 0) {
                return -1;
            }
            int [] dp = new int[amount+1];
            Arrays.fill(dp,amount+1);
            for (int i = 0; i < coins.length; i++) {
                if (coins[i] == amount) {
                    return 1;
                }
                if (coins[i] < amount) {
                    dp[coins[i]] = 1;
                }
            }
            for (int i = 0; i < amount + 1; i++) {
                for (int j = 0; j < coins.length; j++) {
                    if (i - coins[j]<0) {
                        continue;
                    }
                    dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }


            return dp[amount] == amount + 1 ? -1 : dp[amount];
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}