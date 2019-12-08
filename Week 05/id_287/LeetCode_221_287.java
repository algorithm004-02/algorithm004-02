package com.tulane.leetcode.one;

/**
 * 最大正方形
 * Created by Tulane
 * 2019/11/17
 */
public class LeetCode_221 {

    public static void main(String[] args) {
        char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        new LeetCode_221().maximalSquare(matrix);
    }

    /**
     * 动态递归
     * DP
     * a. 重复性:  problem[i,j] = min(sub[i-1,j], sub[i][j-1], sub[i-1][j-1]) + 1
     * b. 状态数组 f[i,j]
     * c. 方程
     *
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int[][] db = new int[matrix.length][matrix[0].length];
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == '1'){
                    if(i == 0 || j == 0) db[i][j] = 1;
                    else db[i][j] = Math.min(Math.min(db[i][j-1], db[i-1][j]), db[i-1][j-1]) + 1;
                    res = Math.max(res, db[i][j]);
                }
            }
        }
        return res * res;
    }
}
