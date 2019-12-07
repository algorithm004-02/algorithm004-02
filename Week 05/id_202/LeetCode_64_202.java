package com.algorithm.qinchao.homework.week05;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/11/16 19:35
 * @description 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * 示例:
 * 输入:
 * [
 *   [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_64_202 {
    /**
     * f(i,j) = min(f(i-1,j),f(i,j-1))+value(i,j)
     * 状态方程：f[n]
     * dp方程 f[i,j] = min(f[i+1,j],f[i+1,j+1])+value[i,j]
     *
     * @param grid
     * @return
     */
    public static int minPathSumByDp(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }

    public static int minPathSumByDivision(int[][] grid) {
        int levelMax = grid.length;
        int columMax = grid[0].length;
        Integer[][] cache = new Integer[grid.length][grid[0].length];
        return recursive(0, 0, cache, grid, levelMax, columMax);
    }

    private static int recursive(int level, int column, Integer[][] cache, int[][] grid, int levelMax, int columMax) {
        if (level == levelMax || column == columMax) {
            return Integer.MAX_VALUE;
        }
        if (cache[level][column] != null) {
            return cache[level][column];
        }
        if (level == levelMax - 1 && column == columMax - 1) {
            return cache[level][column] = grid[level][column];
        }
        return cache[level][column] = Math.min(recursive(level + 1, column, cache, grid, levelMax, columMax),
                recursive(level, column + 1, cache, grid, levelMax, columMax)) + grid[level][column];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(LeetCode_64_202.minPathSumByDp(grid));
        System.out.println(LeetCode_64_202.minPathSumByDivision(grid));
    }
}
