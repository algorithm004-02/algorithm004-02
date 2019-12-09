/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start
class Solution {
    char[][] grid;
    int rowLen = 0;
    int colLen = 0;

    int[] row = new int[] { -1, 1, 0, 0 };
    int[] col = new int[] { 0, 0, -1, 1 };

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        this.grid = grid;
        this.rowLen = grid.length;
        this.colLen = grid[0].length;

        int num = 0;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (grid[i][j] != '0') {
                    dealLands(i, j);
                    num++;
                }
            }
        }
        return num;
    }

    private void dealLands(int i, int j) {
        if (grid[i][j] == 0) {
            return;
        }
        for (int k = 0; k < 4; k++) {
            int x = i + row[k];
            int y = j + col[k];
            if (x >= 0 && x < rowLen && y >= 0 && y < colLen) {
                if (grid[x][y] == '1') {
                    grid[x][y] = '0';
                    dealLands(x, y);
                }
            }
        }
    }
}
// @lc code=end
