public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int reversedN = 0;
        int i = 0;
        while (i < 32) {
            reversedN |= ((n >> i) & 1) << (31 - i);
            i++;
        }
        return reversedN;
    }
}