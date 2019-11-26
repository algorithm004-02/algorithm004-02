//37.解数独
class Solution {
    //回溯法
    public void solveSudoku(char[][] board) {
        //处理边界条件
        if(board == null || board.length == 0)
            return;
        solve(board);
    }
    
    public boolean solve(char[][] board){
        //循环
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.'){
                    for(char c = '1'; c <= '9'; c++){
                        if(isValid(board, i, j, c)){
                            board[i][j] = c; 
                            
                            if(solve(board))
                                return true; //处理成功
                            else
                                board[i][j] = '.'; //回溯
                        }
                    }
                    
                    return false;
                }
            }
        }
        return true;
    }
    
    //判断是否有效
    private boolean isValid(char[][] board, int row, int col, char c){
        for(int i = 0; i < 9; i++) {
            if(board[i][col] != '.' && board[i][col] == c) return false; 
            if(board[row][i] != '.' && board[row][i] == c) return false; 
            if(board[3 * (row / 3) + i / 3][ 3 * (col / 3) + i % 3] != '.' && 
board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false; 
        }
        return true;
    }
}