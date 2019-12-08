/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 *
 * https://leetcode-cn.com/problems/minimum-path-sum/description/
 *
 * algorithms
 * Medium (62.52%)
 * Likes:    315
 * Dislikes: 0
 * Total Accepted:    41.4K
 * Total Submissions: 65.8K
 * Testcase Example:  '[[1,3,1],[1,5,1],[4,2,1]]'
 *
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 
 * 说明：每次只能向下或者向右移动一步。
 * 
 * 示例:
 * 
 * 输入:
 * [
 * [1,3,1],
 * ⁠ [1,5,1],
 * ⁠ [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int minPathSum(int[][] grid) {
        // grid[m][n] = Math.min(grid[m-1][n],grid[m][n-1])
        for (int m = 0; m < grid.length; m++) {
            for (int n = 0; n < grid[0].length; n++) {
                if (m == 0 && n == 0) {
                    continue;
                } else if (m == 0) {
                    grid[m][n] += grid[m][n - 1];
                } else if (n == 0) {
                    grid[m][n] += grid[m - 1][n];
                } else {
                    grid[m][n] += Math.min(grid[m - 1][n], grid[m][n - 1]);
                }
            }
        }

        return grid[grid.length - 1][grid[0].length - 1];
    }
}
// @lc code=end
