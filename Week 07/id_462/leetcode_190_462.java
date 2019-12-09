/**
 * 颠倒二进制位
 */
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result |= (n >> i & 1) << (32 - i - 1);
        }
        return result;
    }
}