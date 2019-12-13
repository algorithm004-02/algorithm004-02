//循环，逐步取反进行拼凑，注意 |= 的使用，拼接二进制。 
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32 ; i++) {
            int temp = (n >> i) & 1;
            temp <<= (31 - i);
            res |= temp;
        }
        return res;
    }
}	