package src.main.java.com.fans.algorithm00402.week7.homework;

/**
 * 颠倒2进制
 */
public class LeetCode_190_232 {

    /**
     * 位运算
     */
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i ++) {
            res = (res << 1) + (n & 1);
            n >>= 1;
        }
        return res;
    }
}
