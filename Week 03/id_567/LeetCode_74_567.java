/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 *
 * https://leetcode-cn.com/problems/search-a-2d-matrix/description/
 *
 * algorithms
 * Medium (35.91%)
 * Likes:    96
 * Dislikes: 0
 * Total Accepted:    20.5K
 * Total Submissions: 56.7K
 * Testcase Example:  '[[1,3,5,7],[10,11,16,20],[23,30,34,50]]\n3'
 *
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 
 * 
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 
 * 
 * 示例 1:
 * 
 * 输入:
 * matrix = [
 * ⁠ [1,   3,  5,  7],
 * ⁠ [10, 11, 16, 20],
 * ⁠ [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * matrix = [
 * ⁠ [1,   3,  5,  7],
 * ⁠ [10, 11, 16, 20],
 * ⁠ [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 * 
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 边界条件
        int m = matrix.length;
        if (m == 0)
            return false;
        int n = matrix[0].length;
        if (n == 0)
            return false;
        if (target < matrix[0][0] || target > matrix[m - 1][n - 1])
            return false;

        // 根据特性取整个矩阵的中间值为mid，依靠除以n的商和余数决定是在哪行哪列
        int low = 0, high = m * n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target < matrix[mid / n][mid % n]) {
                high = mid - 1;
            } else if (target > matrix[mid / n][mid % n]) {
                low = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
// @lc code=end
