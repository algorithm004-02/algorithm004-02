package com.study.week3.lesson11;

/**
 * @Auther: 482-李国栋
 * @Date: 2019/11/1
 * @link
 */
public class LeetCode_74_482 {

    /**
     *
     * @param matrix
     * @param target
     * @return
     *
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;

        int row=0;
        int col=matrix[0].length-1;

        //遍历这个二维数组
        while (row < matrix.length && col>=0) {
            if (target <= matrix[row][col]) {
                if (target == matrix[row][col]) {
                    return true;
                }else {
                    col--;
                }
            }else {
                row++;
            }
        }
        return false;
    }
}
