class Solution {
    public void solveSudoku(char[][] board) {
        slove(board);
    }

    private boolean slove(char[][] board) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++)  {
                int value = board[i][j];
                if (value == '.') {
                    for (char k = '1'; k <= '9'; k++) {
                        //剪枝
                        if (validSudo(board,i,j,k)) {
                            board[i][j] = k;
                            //求解子问题
                            if(slove(board)){
                                return true;
                            }else {
                                //回朔
                                board[i][j] = '.';
                            }
                        }
                    }
                    //1和9填充都不行。说明不能满足数独条件
                    return false;
                }
            }
        }
        //没有进value == '.'的分支。说明都有数字了，最终结尾。
        return true;
    }

    private boolean validSudo(char[][] board, int row, int col, char k) {
        for(int i = 0; i < 9; i++) {
            if(board[i][col] != '.' && board[i][col] == k) return false; //check row
            if(board[row][i] != '.' && board[row][i] == k) return false; //check column
            if(board[3 * (row / 3) + i / 3][ 3 * (col / 3) + i % 3] != '.' &&
                    board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == k) return false; //check 3*3 block
        }
        return true;
    }
}