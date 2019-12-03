class Solution {
    public boolean isPowerOfTwo(int n) {
        //溢出
        if (n == -n) return false;
        return n != 0 && (n & (n - 1)) == 0;
    }
}