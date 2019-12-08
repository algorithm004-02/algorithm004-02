package com.algorithm.qinchao.homework.week03;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/11/3 16:48
 * @description
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例 1:
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 示例 2:
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_74_202 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        // 二分查找
        int left = 0, right = matrix.length * matrix[0].length - 1;
        int arrayIndex, matrixElement;
        while (left <= right) {
            arrayIndex = (left + right) / 2;
            matrixElement = matrix[arrayIndex / matrix[0].length][arrayIndex % matrix[0].length];
            if (target == matrixElement) {
                return true;
            } else {
                if (target < matrixElement) {
                    right = arrayIndex - 1;
                } else {
                    left = arrayIndex + 1;
                }
            }
        }
        return false;
    }

}
