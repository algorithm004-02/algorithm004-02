/*
 * @lc app=leetcode.cn id=200 lang=cpp
 *
 * [200] 岛屿数量
 *
 * https://leetcode-cn.com/problems/number-of-islands/description/
 *
 * algorithms
 * Medium (45.62%)
 * Likes:    263
 * Dislikes: 0
 * Total Accepted:    35.3K
 * Total Submissions: 77.5K
 * Testcase Example:  '[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]'
 *
 * 给定一个由 '1'（陆地）和
 * '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * 
 * 示例 1:
 * 
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 
 * 输出: 1
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * 
 * 输出: 3
 * 
 * 
 */

// @lc code=start
class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        int result = 0;
        for (int i = 0; i < grid.size(); ++i) {
            for (int j = 0; j < grid[i].size(); ++j) {
                // 如果当前格子有陆地，记录当前岛屿，并把该岛屿变为海洋
                if (grid[i][j] == '1') {
                    sink(i, j, grid);
                    // 记录岛屿数量
                    result++;
                }
            }
        }

        return result;
    }

    void sink(int row, int column, vector<vector<char>>& grid) {
        if (row >= grid.size() || column >= grid[row].size()) return;
        
        // 沉默陆地
        grid[row][column] = '0';
        
        // 四个方向遍历
        // 上
        if (row > 0 && grid[row-1][column] == '1') {
            sink(row-1, column, grid);
        }
        // 下
        if (row < grid.size() - 1 && grid[row+1][column] == '1') {
            sink(row+1, column, grid);
        }
        // 左
        if (column > 0 && grid[row][column-1] == '1') {
            sink(row, column-1, grid);
        }
        // 右
        if (column < grid[row].size() - 1 && grid[row][column+1] == '1') {
            sink(row, column+1, grid);
        }
    }
};
// @lc code=end

