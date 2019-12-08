package com.algorithm.qinchao.homework.week05;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/11/17 10:57
 * @description 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 * 示例:
 * 输入:
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * 输出: 4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximal-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_221_202 {
    /**
     * 重复子问题： value ==1? f(i,j) = min(f(i-1,j),f(i,j-1),f(i-1,j-1))+1  :f(i,j) = 0
     * 状态函数：dp[i][j]
     * dp方程：value ==1? f[,j] = min(f[i-1,j],f[i,j-1],f[i-1,j-1]) +1  :f(i,j) = 0
     *
     * @param matrix
     * @return
     */
    public static int maximalSquare(char[][] matrix) {
        int level = matrix.length;
        int column = matrix[0].length;
        int[][] dp = new int[level + 1][column + 1];
        int maxLength = 0;
        for (int i = 1; i <= level; i++) {
            for (int j = 1; j <= column; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    maxLength = Math.max(maxLength, dp[i][j]);
                }
            }
        }
        return maxLength * maxLength;
    }

    public static void main(String[] args) {
        System.out.println(LeetCode_221_202.maximalSquare(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}}));
    }
}
