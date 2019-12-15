class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] row = new int[9];
        int[] col = new int[9];
        int[] sub = new int[9];
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                //当前字符是'.'则跳过, 直接进入下一轮循环
                if(board[i][j]=='.')
                    continue;
                //处理行
                if(!valid(row, i, board[i][j]-48))
                    return false;
                //处理列
                if(!valid(col, j, board[i][j]-48))
                    return false;
                //处理子数独
                int index = i/3*3 + j/3;
                if(!valid(sub, index, board[i][j]-48))
                    return false;
            }
        }
        return true;
    }
    public boolean valid(int[] arr, int i, int cur){
        //cur出现过, 返回false
        if(((arr[i]>>cur)&1)==1)
            return false;
        //cur没出现过, 标记为出现过
        arr[i] = arr[i] | (1<<cur);
        return true;
    }

}