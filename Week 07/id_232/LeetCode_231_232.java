package src.main.java.com.fans.algorithm00402.week7.homework;

/**
 * 2的幂
 */
public class LeetCode_231_232 {

    /**
     * 位运算
     */
    public boolean isPowerOfTwo(int n) {
        int res = n & (n - 1);
        return (n > 0) && (res == 0);
    }
}
