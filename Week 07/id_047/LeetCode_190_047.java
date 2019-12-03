public class LeetCode_190_047 {
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i ++) {
            res += (n & 1) << (31 - i);
            n = n >> 1;
        }
        return res;
    }
}
