package app.homeworkWeekFifth;
/*
 * @lc app=leetcode id=62 lang=java
 *
 * [62] Unique Paths
 *
 * https://leetcode.com/problems/unique-paths/description/
 *
 * algorithms
 * Medium (49.61%)
 * Likes:    2070
 * Dislikes: 153
 * Total Accepted:    354.6K
 * Total Submissions: 709.2K
 * Testcase Example:  '3\n2'
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in
 * the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot
 * is trying to reach the bottom-right corner of the grid (marked 'Finish' in
 * the diagram below).
 * 
 * How many possible unique paths are there?
 * 
 * 
 * Above is a 7 x 3 grid. How many possible unique paths are there?
 * 
 * Note: m and n will be at most 100.
 * 
 * Example 1:
 * 
 * 
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the
 * bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: m = 7, n = 3
 * Output: 28
 * 
 */

// @lc code=start
class Solution {
    public int uniquePaths(int m, int n) {
        return uniquePaths_dp(m, n);
    }

    /**
     * n代码二维数组的长度，m代表二维数组数组中每个数组的长度
     * 设起点为(0,0)终点为(n,m),到达终点只有两种路径，（n,m-1）,(n-1,m),
     * 到达（n,m-1）的也只有两种路径(n,m-1)(n-1,m-1),依次类推
     * dp方程f(n,m) = f(n,m-1) + f(n-1,m)
     * 时间复杂度O(m*n)
     * 空间复杂度O(m*n)
     * @param m
     * @param n
     * @return
     */
    private int uniquePaths_dp(int m, int n) {
        if (m == 0 || n == 0) return 0;
        int [][] cache = new int [n][m];
        for (int i = 0; i < m; i++) cache[0][i] = 1;
        for (int i = 0; i < n; i++) cache[i][0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                cache[i][j] = cache[i][j - 1] + cache[i - 1][j];
            }
        }
        return cache[n - 1][m - 1];
    }
}
// @lc code=end

