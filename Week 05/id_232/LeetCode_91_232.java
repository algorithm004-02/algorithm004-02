package src.main.java.com.fans.algorithm00402.week5.homework;

import javax.imageio.metadata.IIOMetadataFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 解码方法
 */

public class LeetCode_91_232 {

    /**
     * dp
     *  - 类比爬楼梯， 一次可以爬一步或者两步
     *  - 子问题：f(n) = f(n - 1) + f(n - 2)
     *  - dp数组：dp[n]
     */
//    public int numDecodings(String s) {
//        char[] chars = s.toCharArray();
//        if (chars[0] == '0') return 0;
//        if (chars.length == 1) return 1;
//        int[] dp = new int[chars.length];
//        dp[0] = 1;
//        if (chars[1] == '0') {
//            if (chars[0] == '1' || chars[0] == '2') dp[1] = 1;
//            else return 0;
//        } else if (chars[0] == '2' && chars[1] > '6' || chars[0] >= '3'){
//            dp[1] = 1;
//        } else {
//            dp[1] = 2;
//        }
//        for (int i = 2; i < chars.length; i ++) {
//            if (chars[i] == '0') {
//                if (chars[i - 1] == '1' || chars[i - 1] == '2') dp[i] = dp[i - 2];
//                else return 0;
//            } else if (chars[i - 1] == '1' || (chars[i - 1] == '2' && chars[i] <= '6'))
//                dp[i] = dp[i - 1] + dp[i - 2];
//            else dp[i] = dp[i - 1];
//        }
//        return dp[chars.length - 1];
//    }

    /**
     * 简化dp
     */
    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        if (chars[0] == '0') return 0;
        if (chars.length == 1) return 1;
        int pre = 1, cur = 1;
        for (int i = 1; i < chars.length; i ++) {
            int tmp = cur;
            if (chars[i] == '0')
                if (chars[i - 1] == '1' || chars[i - 1] == '2') cur = pre;
                else return 0;
            else if (chars[i - 1] == '1' || (chars[i - 1] == '2' && chars[i] <= '6'))
                cur = pre + cur;
            pre = tmp;
        }
        return cur;
    }
}
