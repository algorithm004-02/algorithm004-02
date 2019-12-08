package com.algorithm.qinchao.homework.week06;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/11/20 19:02
 * @description
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * 示例:
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 解释:
 *
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/surrounded-regions
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_130_202 {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int level = board.length;
        int column = board[0].length;
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        for (int i = 0; i < level; i++) {
            for (int j = 0; j < column; j++) {
                if (i == 0 || j == 0 || i == level - 1 || j == column - 1) {
                    if (board[i][j] == 'O') {
                        recursive(i, j, dx, dy,board);
                    }
                }
            }
        }
        for (int i = 0; i < level; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void recursive(int i, int j, int[] dx, int[] dy, char[][] board) {
        board[i][j] = '*';
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && x < board.length && y >= 0 && y < board[i].length && board[x][y] == 'O') {
                recursive(x, y, dx, dy, board);
            }
        }
    }
}
