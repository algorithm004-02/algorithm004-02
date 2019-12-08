/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 *
 * https://leetcode-cn.com/problems/search-a-2d-matrix/description/
 *
 * algorithms
 * Medium (35.90%)
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
        int x=matrix.length;
        if (x == 0) {
            return false;
        }
        int y=matrix[0].length;
        int left=0;
        int right=x*y-1;    
        int mid, data;   
        while(left<=right){
            mid=(left+right)/2;
            data=matrix[mid / y][mid % y];
            if (target==data) {
                return true;
            } else if (target > data) {
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }
        return false;
    }
}
// @lc code=end

