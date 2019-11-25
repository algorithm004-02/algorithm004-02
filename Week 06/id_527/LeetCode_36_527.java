/*
 * @lc app=leetcode.cn id=36 lang=java
 *
 * [36] 有效的数独
 */

// @lc code=start
class Solution {
    char[][] grid;

    public boolean isValidSudoku(char[][] board) {
        this.grid = board;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (!checkValid(i, j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean checkValid(int i, int j) {
        for (int k = 0; k < 9; k++) {
            if (k != i && grid[k][j] == grid[i][j]) {
                return false;
            }
            if (k != j && grid[i][k] == grid[i][j]) {
                return false;
            }
            int indexI = (i / 3) * 3;
            int indexJ = (j / 3) * 3;
            for (int l = 0; l < 3; l++) {
                for (int l2 = 0; l2 < 3; l2++) {
                    int a = indexI + l;
                    int b = indexJ + l2;
                    if (a != i && b != j && grid[a][b] == grid[i][j]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
// @lc code=end
