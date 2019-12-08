import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=529 lang=java
 *
 * [529] 扫雷游戏
 */

// @lc code=start
class Solution {
    char[][] grid;
    int rowLen = 0;
    int colLen = 0;

    int[] row = new int[] { -1, 1, 0, 0, -1, -1, 1, 1 };
    int[] col = new int[] { 0, 0, -1, 1, -1, 1, -1, 1 };

    Set<Integer> set = new HashSet<>();

    public char[][] updateBoard(char[][] board, int[] click) {
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        this.grid = board;
        this.rowLen = grid.length;
        this.colLen = grid[0].length;
        dealBoard(click[0], click[1]);
        return board;
    }

    private void dealBoard(int i, int j) {
        int num = getNum(i, j);
        if (num == 0) {
            grid[i][j] = 'B';
        } else {
            grid[i][j] = Character.forDigit(num, 10);
            return;
        }
        for (int k = 0; k < 8; k++) {
            int x = i + row[k];
            int y = j + col[k];
            if (x >= 0 && x < rowLen && y >= 0 && y < colLen && grid[x][y] == 'E') {
                dealBoard(x, y);
            }
        }
    }

    private int getNum(int i, int j) {
        int num = 0;
        for (int k = 0; k < 8; k++) {
            int x = i + row[k];
            int y = j + col[k];
            if (x >= 0 && x < rowLen && y >= 0 && y < colLen && grid[x][y] == 'M') {
                num++;
            }
        }
        return num;
    }
}
// @lc code=end
