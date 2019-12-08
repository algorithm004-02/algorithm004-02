package src.main.java.com.fans.algorithm00402.week5.homework;

import java.util.LinkedList;
import java.util.List;

/**
 * 戳气球
 */
public class LeetCode_312_232 {

    /**
     * 回溯
     */
//    private int ans = 0;
//    public int maxCoins(int[] nums) {
//
//        List<Integer> list = new LinkedList<>();
//        for (int i = 0; i < nums.length; i ++) list.add(nums[i]);
//        dfs(list, 0);
//        return ans;
//    }
//    private void dfs(List<Integer> list, int coins) {
//        if (list.size() == 0) {
//            ans = Math.max(coins, ans);
//        }
//
//        for (int i = 0; i < list.size(); i ++) {
//            int tmp = list.get(i);
//            int sum = list.get(i) * (i - 1 < 0 ? 1 : list.get(i - 1)) * (i + 1 < list.size() ? list.get(i + 1) : 1);
//            list.remove(i);
//            dfs(list, coins + sum);
//            list.add(i , tmp);
//        }
//    }

    /**
     * 记忆化递归 + DP
     *  - 逆向思维， 自顶向下 k 为最后一个点爆的气球
     *      a. dp子问题 f(n, m) = f(k + 1, m) + f(n, k - 1) + nums[n - 1] * nums[k] * nums[m + 1]
     *      b. dp 数组 dp[n, m] 表示 n 到 m 之间可以产生的最大价值
     *      c. dp 方程 f(n, m) = f(k + 1, m) + f(n, k - 1) + nums[n - 1] * nums[k] * nums[m + 1]
     */
//    public int maxCoins(int[] nums) {
//        LinkedList<Integer> list = new LinkedList<>();
//        for (int i = 0; i < nums.length; i ++) list.add(nums[i]);
//        list.addFirst(1);
//        list.addLast(1);
//        int[][] dp = new int[nums.length + 2][nums.length + 2];
//        return helper(list, 0, nums.length, dp);
//    }
//
//    private int helper(LinkedList<Integer> list, int i, int j, int[][] dp) {
//        if (i > j) return 0;
//        if (dp[i][j] != 0) return dp[i][j];
//
//        for (int k = i; k <= j; k ++) {
//            int left = helper(list, i, k - 1, dp);
//            int right = helper(list, k + 1, j, dp);
//            int detal = list.get(k) * list.get(i - 1) * list.get(j + 1);
//            dp[i][j] = Math.max(dp[i][j], left + right + detal);
//        }
//
//        return dp[i][j];
//    }

    /**
     * 优化的DP
     */
    public int maxCoins(int[] nums) {
        if (nums.length == 0) return 0;
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int len = 1; len <= n; len ++) {
            for (int i = 0; i <= n - len; i ++) {
                int j = i + len - 1;
                for (int k = i; k <= j; k ++) {
                    int past = (i - 1 < 0 ? 1 : nums[i - 1]);
                    int next = (j + 1 < n ? nums[j + 1] : 1);
                    int right = k + 1 < n ? dp[k + 1][j] : 0;
                    int left = k - 1 < 0 ? 0 : dp[i][k - 1];
                    dp[i][j] = Math.max(dp[i][j], right + left + nums[k] * past * next);
                }
            }
        }

        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        LeetCode_312_232 code = new LeetCode_312_232();
        code.maxCoins(new int[]{3,1,5,8});
    }
}
