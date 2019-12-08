/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) {
            return false;
        }
        int rowLen = matrix.length;
        int colLen = 0;
        if (rowLen != 0) {
            colLen = matrix[0].length;
        }
        int totalCount = rowLen * colLen;

        int left = 0;
        int right = totalCount - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int r = mid / colLen;
            int c = mid % colLen;
            if (matrix[r][c] == target) {
                return true;
            } else if (matrix[r][c] < target) {
                left = mid + 1;
            } else {
                right = right - 1;
            }
        }
        return false;
    }
}
// @lc code=end
