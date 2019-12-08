/*
 * @lc app=leetcode.cn id=221 lang=java
 *
 * [221] 最大正方形
 *
 * https://leetcode-cn.com/problems/maximal-square/description/
 *
 * algorithms
 * Medium (38.29%)
 * Likes:    166
 * Dislikes: 0
 * Total Accepted:    14.7K
 * Total Submissions: 38.2K
 * Testcase Example:  '[["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]'
 *
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 * 
 * 示例:
 * 
 * 输入: 
 * 
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * 
 * 输出: 4
 * 
 */

// @lc code=start
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;

        int n = matrix.length, m = matrix[0].length;
        int[] dp = new int[m + 1];
        int maxSideLen = 0, prev = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int temp = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = Math.min(Math.min(dp[j - 1], prev), dp[j]) + 1;
                    maxSideLen = Math.max(maxSideLen, dp[j]);
                } else {
                    dp[j] = 0;
                }
                prev = temp;
            }
        }
        return maxSideLen * maxSideLen;
    }
}
// @lc code=end
