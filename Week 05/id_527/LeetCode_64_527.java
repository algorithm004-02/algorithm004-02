/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 *
 * https://leetcode-cn.com/problems/minimum-path-sum/description/
 *
 * algorithms
 * Medium (62.80%)
 * Likes:    313
 * Dislikes: 0
 * Total Accepted:    40.9K
 * Total Submissions: 65K
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
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int rowLen = grid.length;
        int colLen = grid[0].length;
        for (int i = 1; i < rowLen; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int i = 1; i < colLen; i++) {
            grid[0][i] += grid[0][i - 1];
        }
        for (int i = 1; i < rowLen; i++) {
            for (int j = 1; j < colLen; j++) {
                grid[i][j] += Math.min(grid[i][j - 1], grid[i - 1][j]);
            }
        }
        return grid[rowLen - 1][colLen - 1];
    }
}
// @lc code=end
