class Solution {
    
    private int size;
    
    private int count;
    public int totalNQueens(int n) {
        
        //Check boundary
        
        if (n == 0) {
            return 0;
        }
        
        //Intialize
        
        count = 0;
        size = (1 << n) - 1;
        
        //process
        
        backtrack(0, 0,0);
        
        //return
        
        return count;
        
    }
    
    public void backtrack(int row, int left, int right) {
        
        //termiate
        if(row == size) {
            count++;
            return ;
            
        }
        
        //
        int pos = size & ~ (row | left | right);
        
        while (pos != 0){
            int p  = pos & (-pos);
            pos -= p;
            
            backtrack(row|p, (left | p) << 1, (right|p) >> 1);
            
        }
        
        
    }
}