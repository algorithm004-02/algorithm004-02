/*
 * @lc app=leetcode.cn id=74 lang=cpp
 *
 * [74] 搜索二维矩阵
 *
 * https://leetcode-cn.com/problems/search-a-2d-matrix/description/
 *
 * algorithms
 * Medium (35.91%)
 * Likes:    94
 * Dislikes: 0
 * Total Accepted:    19.9K
 * Total Submissions: 55.1K
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
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        if (matrix.empty()) return false;

        int l = 0, h = matrix.size() - 1;
        // 两层折半查找，找到符合范围的行
        while (l <= h) {
            int m = l + (h - l) / 2;

            if (matrix[m].empty()) return false;

            if (target >= matrix[m][0] && target <= matrix[m][matrix[m].size() - 1]) {
                // 在行中折半查找目标
                return bisearch(matrix[m], target);
            } else if (target < matrix[m][0]) {
                h = m - 1;
            } else if (target > matrix[m][matrix[m].size() - 1]) {
                l = m + 1;
            } else {
                assert(false);
            }
        }

        return false;
    }

    bool bisearch(vector<int>& arr, int target) {
        if (arr.empty()) return false;

        int l = 0, h = arr.size() - 1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (target == arr[m]) {
                return true;
            } else if (target < arr[m]) {
                h = m - 1;
            } else if (target > arr[m]) {
                l = m + 1;
            } else {
                assert(false);
            }
        }

        return false;
    }
};
// @lc code=end

