package src.main.java.com.fans.algorithm00402.week7.homework;

/**
 * 位1的个数
 */
public class LeetCode_191_232 {

    // you need to treat n as an unsigned value

    /**
     * 位运算
     */
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count ++;
        }
        return count;
    }

    /**
     * 位运算2
     */
//    public int hammingWeight(int n) {
//        int count = 0;
//        int tag = 1;
//        for (int i = 0; i < 32; i ++) {
//            int res = n & tag;
//            if (res == tag) count ++;
//            tag = tag << 1;
//        }
//        return count;
//    }
}
