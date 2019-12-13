package src.main.java.com.fans.algorithm00402.week7.homework;

import java.lang.reflect.Array;

/**
 * 比特位计数
 */
public class LeetCode_338_232 {

    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 0; i <= num; i ++) {
            int count = 0;
            int tmp = i;
            while (tmp != 0) {
                tmp = tmp & (tmp - 1);
                count ++;
            }
            ans[i] = count;
        }

        return ans;
    }
}
