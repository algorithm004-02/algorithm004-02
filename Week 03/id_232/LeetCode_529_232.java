package src.main.java.com.fans.algorithm00402.week3.homework;

import com.sun.nio.sctp.PeerAddressChangeNotification;

import java.util.*;

/**
 * 扫雷游戏
 */
class LeetCode_529_232 {

    /**
     * 1. DFS
     */
//    public char[][] updateBoard(char[][] board, int[] click) {
//
//        int row = click[0];
//        int col = click[1];
//
//        // 先判断点击的是什么
//        char ch = board[row][col];
//        if (ch == 'M') {
//            board[row][col] = 'X';
//        } else if (ch == 'E') {
//            // 这是一个空方块
//            helper(board, row, col);
//        }
//
//        return board;
//    }
//
//    private void helper(char[][] board, int row, int col) {
//        board[row][col] = '0';
//        // terminator - 判断周围是否有地雷
//
//        // process
//        for (int i = row - 1; i <= row + 1; i ++) {
//            for (int j = col - 1; j <= col + 1; j ++) {
//                if (i >= 0 && j >= 0 && i < board.length && j < board[0].length && board[i][j] == 'M') {
//                    board[row][col] = (char) (board[row][col] + 1);
//                }
//            }
//        }
//
//        if (board[row][col] == '0') {
//            board[row][col] = 'B';
//            for (int i = row - 1; i <= row + 1; i ++) {
//                for (int j = col - 1; j <= col + 1; j ++) {
//                    if (i >= 0 && j >= 0 && i < board.length && j < board[0].length && board[i][j] == 'E') {
//                        helper(board, i, j);
//                    }
//                }
//            }
//        }
//    }


    /**
     * 2. BFS
     */
    public char[][] updateBoard(char[][] board, int[] click) {

        int row = click[0];
        int col = click[1];

        // 先判断点击的是什么
        char ch = board[row][col];
        if (ch == 'M') {
            board[row][col] = 'X';
        } else if (ch == 'E') {
            // 这是一个空方块
            bfs(board, row, col);
        }

        return board;
    }

    private void bfs(char[][] board, int row, int col) {

        int maxRow = board.length;
        int maxCol = board[0].length;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(helper(row, col, maxCol));
        Set<Integer> cache = new HashSet<>(); // 防止重复入队
        cache.add(helper(row, col, maxCol));
        while (!queue.isEmpty()) {
            int tag = queue.poll();
            int tempRow = tag / maxCol;
            int tempCol = tag % maxCol;
            board[tempRow][tempCol] = '0';
            for (int i = tempRow - 1; i <= tempRow + 1; i ++) {
                for (int j = tempCol - 1; j <= tempCol + 1; j ++) {
                    if (i >= 0 && j >= 0 && i < maxRow && j < maxCol && board[i][j] == 'M') {
                        board[tempRow][tempCol] = (char) (board[tempRow][tempCol] + 1);
                    }
                }
            }

            if (board[tempRow][tempCol] == '0') {
                board[tempRow][tempCol] = 'B';
                for (int i = tempRow - 1; i <= tempRow + 1; i ++) {
                    for (int j = tempCol - 1; j <= tempCol + 1; j ++) {
                        if (i >= 0 && j >= 0 && i < maxRow && j < maxCol && board[i][j] == 'E' && !cache.contains(helper(i, j, maxCol))) {
                            cache.add(helper(i, j, maxCol));
                            queue.add(helper(i, j, maxCol));
                        }
                    }
                }
            }
        }
    }

    private int helper(int row, int col, int maxCol) {
        return row * maxCol + col;
    }


}
