package src.main.java.com.fans.algorithm00402.week5.homework;

/**
 * 最小路径和
 */
public class LeetCode_64_232 {

    /**
     * dp
     *  - 分治子问题 ： f(m, n) = grid(m, n) + min(f(m - 1, n), f(m, n - 1))
     *  - DP 数组 ： dp[m][n] 当前点的最小路径
     *  - DP 公式 ： dp[m][n] = grid[m][n] + min(dp[m - 1][n], dp[m][n - 1])
     */
//    public int minPathSum(int[][] grid) {
//        if (grid.length == 0) return 0;
//        int m = grid.length;
//        int n = grid[0].length;
//        int[][] dp = new int[m][n];
//        for (int i = 0; i < m; i ++) dp[i][0] = grid[i][0];
//        for (int i = 0; i < n; i ++) dp[0][i] = grid[0][i];
//
//        for (int i = 1; i < m; i ++) {
//            for (int j = 1; j < n; j ++) {
//                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
//            }
//        }
//        return dp[m - 1][n - 1];
//    }

    /**
     * 一维dp
     */
    public int minPathSum(int[][] grid) {
        if (grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        dp[0] = grid[0][0];
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (j == 0)
                    dp[j] = dp[j] + grid[i][j];
                else
                    dp[j] = grid[i][j] + Math.min(dp[j - 1], dp[j]);
            }
        }
        return dp[n - 1];
    }
}
