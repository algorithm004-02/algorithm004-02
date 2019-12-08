/**
 * 2的幂
 * Created by yangwenwei on 2019/11/25.
 */
public class LeetCode_231_597 {
    class Solution {
        public boolean isPowerOfTwo(int n) {
            return n > 0 && ((n & (n - 1)) == 0);
        }
    }
}
