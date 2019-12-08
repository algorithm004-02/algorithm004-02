/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 *
 * https://leetcode-cn.com/problems/minimum-path-sum/description/
 *
 * algorithms
 * Medium (62.53%)
 * Likes:    317
 * Dislikes: 0
 * Total Accepted:    42K
 * Total Submissions: 66.7K
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
    // public int minPathSum(int[][] grid) {
    //     //dp[m,n]=min(dp[m+1,n],dp[m,n+1])+a[m,n]
    //     //两边动态规划
    //     int[][] dp = new int[grid.length][grid[0].length];
    //     for (int i = grid.length - 1; i >= 0; i--) {
    //         for (int j = grid[0].length - 1; j >= 0; j--) {
    //             if(i == grid.length - 1 && j != grid[0].length - 1){
    //                 dp[i][j] = grid[i][j] +  dp[i][j + 1];
    //             }
    //             else if(j == grid[0].length - 1 && i != grid.length - 1){
    //                 dp[i][j] = grid[i][j] + dp[i + 1][j];
    //             }
    //             else if(j != grid[0].length - 1 && i != grid.length - 1){
    //                 dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
    //             }
    //             else{
    //                 dp[i][j] = grid[i][j];
    //             }
    //         }
    //     }
    //     return dp[0][0];
    // }

        public int minPathSum(int[][] grid) {
        //dp[m,n]=min(dp[m+1,n],dp[m,n+1])+a[m,n]
        //一遍动态规划
        int[] dp = new int[grid[0].length];
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if(i == grid.length - 1 && j != grid[0].length - 1){
                    dp[j] = grid[i][j] +  dp[j + 1];
                }
                else if(j == grid[0].length - 1 && i != grid.length - 1){
                    dp[j] = grid[i][j] + dp[j];
                }
                else if(j != grid[0].length - 1 && i != grid.length - 1){
                    dp[j] = grid[i][j] + Math.min(dp[j], dp[j + 1]);
                }
                else{
                    dp[j] = grid[i][j];
                }
            }
        }
        return dp[0];
    }
}
// @lc code=end

