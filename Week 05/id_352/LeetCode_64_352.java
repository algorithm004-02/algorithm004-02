/**
 * @(#)MinimumPathSum.java, Nov 17, 2019.
 * <p>
 * Copyright 2019 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * @author helloliu
 */

/**
 * 1:暴力求解，每次有两种不同的走法,我们只需要在两种中选择一种路径和最小的,也就是说
 *   PathSum[i] = num[i][j] + min(PathSum[i + 1][j] + PathSum[i][j + 1]);
 *
 *
 * 2:DP,这里其实很容易在暴力的基础上做第一个版本的迭代,也就是基于暴力求解的自底向上的循环,PathSum[i] = num[i][j] +
 *   min(PathSum[i + 1][j] + PathSum[i][j + 1])，本身也可以看作是我们子问题的划分和状态转移方程
 *
 * 3:DP,优化，这里其实每次求解PathSum[i]是，最复杂的情况也就是i和j没有在边界上，处于中间位置，这样会求解（i，j + 1） 和 （i + 1, j）也就是说最复杂的情况也只是设计到当前行和前一行，也就是说我们可以将M * N 的数组简化成为2 * n
 */
public class MinimumPathSum {

    //暴力求解
    public int minPathSum1(int[][] grid) {
        if (grid == null || grid.length <= 0) {
            return Integer.MAX_VALUE;
        }
        return pathSum1(grid, 0, 0);
    }

    private int pathSum1(int[][] grid, int i, int j) {
        if (i >= grid.length  || j >= grid[0].length) {
            return Integer.MAX_VALUE;
        }

        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return grid[i][j];
        }
        return grid[i][j] + Math.min(pathSum1(grid, i+1, j), pathSum1(grid ,i, j + 1));
    }

    //基于暴力求解的，自底向上的循环
    public int minPathSum2(int[][] grid) {
        if (grid.length <= 0 || grid[0].length <= 0) {
            return Integer.MAX_VALUE;
        }
        int[][] result = new int[grid.length][grid[0].length];
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length -1; j >= 0;  j--) {
                if (i == grid.length - 1 && j != grid[0].length - 1) {
                    result[i][j] = grid[i][j] + result[i][j + 1];
                } else if (i != grid.length - 1 && j == grid[0].length - 1) {
                    result[i][j] = grid[i][j] + result[i + 1][j];
                } else if (i != grid.length - 1 && j != grid[0].length -1) {
                    result[i][j] = grid[i][j] + Math.min(result[i + 1][j], result[i][j + 1]);
                } else {
                    result[i][j] = grid[i][j];
                }
            }
        }

        return result[0][0];
    }

}