package com.tulane.leetcode.one;

import java.util.Arrays;

/**
 * 不同路径
 * Created by Tulane
 * 2019/11/16
 */
public class LeetCode_62 {

    /**
     * 优化版2
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j-1];
            }
        }
        return dp[n-1];
    }

    /**
     * 优化版1, 将左格子缓存起来, 当换行时重置为1
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths2(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            int pre = 1;
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + pre;
                pre = dp[j];
            }
        }
        return dp[n - 1];
    }

    /**
     * 先得出递推公式: 格子的总路径 = 上格子的总路径 + 左格子的总路径
     * 得出最左侧边和最上侧边的所有格子的路径皆为1
     * 从[1][1]开始遍历, 得出[m-1][n-1]的总路径
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths1(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int j = 0; j < n; j++) dp[0][j] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                //递推方程
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
