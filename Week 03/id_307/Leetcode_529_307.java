class Solution {
    private int getMineNumber(char[][] board, int x, int y) {
        //遍历 8 个方向
        int mines = 0;
        for (int dy = -1; dy < 2; dy++) {
            for (int dx = -1; dx < 2; dx++) {
                if (dy == 0 && dx == 0) {
                    continue;
                }
                int tx = x + dx;
                int ty = y + dy;
                if (tx > -1 && ty > -1 && ty < board.length && tx < board[ty].length && board[ty][tx] == 'M') {
                    mines++;
                }
            }
        }
        return mines;
    }
    private void sweeperDfs(char[][] board, int x, int y) {
        int num = getMineNumber(board, x, y);
        if (num == 0) {
            board[y][x] = 'B';
        } else {
            board[y][x] = Character.forDigit(num, 10);
            return;
        }
        for (int dy = -1; dy < 2; dy++) {
            for (int dx = -1; dx < 2; dx++) {
                if (dy == 0 && dx == 0) {
                    continue;
                }
                int tx = x + dx;
                int ty = y + dy;
                if (tx > -1 && ty > -1 && ty < board.length && tx < board[ty].length && board[ty][tx] == 'E') {
                    sweeperDfs(board, tx, ty);                    
                }
            }
        }
    }
    public char[][] updateBoard(char[][] board, int[] click) {
        int y = click[0];
        int x = click[1];
        switch (board[y][x]) {
            case 'M':
                board[y][x] = 'X';
                break;
            case 'E':
                sweeperDfs(board, x, y);
                break;
        }
        return board;
    }
}