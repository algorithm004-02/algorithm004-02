class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer,Integer>[] rows = new HashMap[9];
        HashMap<Integer,Integer>[] cols = new HashMap[9];
        HashMap<Integer,Integer>[] boxes =  new HashMap[9];
        for (int i = 0; i <9 ; i++) {
            rows[i]=new HashMap<>();
            cols[i]=new HashMap<>();
            boxes[i]=new HashMap<>();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if(num!='.'){
                    int n = num;
                    int boxNum =  (i / 3 ) * 3 + j / 3;
                    rows[i].put(n,rows[i].getOrDefault(n,0)+1);
                    cols[j].put(n,cols[j].getOrDefault(n,0)+1);
                    boxes[boxNum].put(n,boxes[boxNum].getOrDefault(n,0)+1);
                    if(rows[i].get(n)>1||cols[j].get(n)>1||boxes[boxNum].get(n)>1){
                        return false;
                    }
                }


            }
        }
        return true;
    }
}