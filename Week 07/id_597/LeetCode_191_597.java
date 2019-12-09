/**
 * 位1的个数
 * Created by yangwenwei on 2019/11/25.
 */
public class LeetCode_191_597 {
    public class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int count = 0;
            while (n != 0) {
                count++;
                n &= n - 1;
            }
            return count;
        }

        public int hammingWeight1(int n) {
            int count = 0, pos = 1;
            for (int i = 0; i < 32; i++) {
                if((n & pos) != 0) count++;
                pos <<= 1;
            }
            return count;
        }
    }
}
