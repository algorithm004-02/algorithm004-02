class Solution {
    int n = 3;
    int N = 9 ;
    int[][] rows = new int[N][N+1];
    int[][] cols = new int[N][N+1];
    int[][] boxes = new int[N][N+1];
    char[][] board;
    boolean isSolved =false;
    public void solveSudoku(char[][] board) {

        this.board =board;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(board[i][j]!='.'){
                    int d = Character.getNumericValue(board[i][j]);
                    placeNumOnBoard(d,i,j);
                }
            }
        }

        backTrack(0,0);

    }

    private void backTrack(int row, int col) {
        if(board[row][col]=='.'){
            for (int i = 1; i < N+1; i++) {
                if(couldPlaceNum(i,row,col)) {
                    placeNumOnBoard(i, row, col);
                    placeNextNumbers(row, col);
                    if (!isSolved) {
                        removeNumOnBoard(i, row, col);
                    }
                }
            }
        }else {
            placeNextNumbers(row,col);
        }

    }

    private boolean couldPlaceNum(int d, int row, int col) {
        return rows[row][d] + cols[col][d] + boxes[getBoxIndex(row,col)][d] == 0;
    }

    private void removeNumOnBoard(int d, int row, int col) {
        rows[row][d]--;
        cols[col][d]--;
        boxes[getBoxIndex(row,col)][d]--;
        board[row][col]= '.';
    }

    private void placeNextNumbers(int row, int col) {
        if(row==N-1&&col==N-1){
            isSolved = true;
        }else {
            if(col == N-1) {backTrack(row+1,0);}
            else {
                backTrack(row,col+1);
            }
        }
    }

    private void placeNumOnBoard(int d, int row, int col) {
        rows[row][d]++;
        cols[col][d]++;
        boxes[getBoxIndex(row,col)][d]++;
        board[row][col]= (char) (d+'0');
    }

    private int getBoxIndex(int row,int col){
        return row/n*n+col/n;

    }

}