package com.tulane.leetcode.one;

/**
 * Created by Tulane
 * 2019/11/17
 */
public class LeetCode_64 {

    public static void main(String[] args) {
        int[][] test =
                {{1, 2}, {5, 6}, {1, 1}};
        new LeetCode_64().minPathSum(test);
    }

    /**
     * DP
     * 重复性: problem[i,j] = Min( subproblem[i-1,j], subproblem[i, j-1] )
     * 状态数组: f[i,j]
     * 方程:
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int[] db = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (j == 0)
                    db[j] += grid[i][j];
                else if (i == 0)
                    db[j] = db[j - 1] + grid[i][j];
                else
                    db[j] = Math.min(db[j], db[j - 1]) + grid[i][j];
            }
        }
        return db[db.length - 1];
    }
}
