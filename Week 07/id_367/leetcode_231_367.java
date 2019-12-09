我的解法
class Solution {
    public boolean isPowerOfTwo(int n) {
        int m;
        m = n;
        if(m <= 0) return false;
       if((m & (m - 1)) == 0) return true;
        return false; 
      
    }
}
//简洁代码
class Solution {
    public boolean isPowerOfTwo(int n) {
         return n > 0 && (n & (n - 1)) == 0;
    }
}