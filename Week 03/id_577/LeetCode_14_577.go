class Solution {
    public boolean isPerfectSquare(int num) {
        
        //user binary search 
        int left = 1;
        int right = num;
        
        while( left <= right) {
            long mid = (left + right) /2; 
            
            if ( mid * mid == num) {
                return true;
            } else if ( mid * mid > num ) {
                right =(int)mid - 1;
            } else {
                left = (int)mid + 1;
            }
        }
        
        return false;
        
        
        
    }
}