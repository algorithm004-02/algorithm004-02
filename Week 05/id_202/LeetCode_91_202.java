package com.algorithm.qinchao.homework.week05;

import java.util.HashMap;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/11/16 20:54
 * @description 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * 示例 1:
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2:
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-ways
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_91_202 {
    public static int numDecodingsByRecursive(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashMap<Integer, Integer> cache = new HashMap<>();
        return recursive(0, s, cache);
    }

    private static int recursive(int level, String s, HashMap<Integer, Integer> cache) {
        if (cache.containsKey(level)) {
            return cache.get(level);
        }
        if (level == s.length()) {
            return 1;
        }
        if (s.charAt(level) == '0') {
            return 0;
        }
        int ans1 = recursive(level + 1, s, cache);
        int ans2 = 0;
        if (level <= s.length() - 2) {
            int ten = (s.charAt(level) - '0') * 10;
            int one = s.charAt(level + 1) - '0';
            if (ten + one <= 26) {
                ans2 = recursive(level + 2, s, cache);
            }
        }
        cache.put(level, ans1 + ans2);
        return ans1 + ans2;
    }

    /**
     * 子问题：f(n) = f(n+1)+ s(n+1)+s(n+2)<=26? f(n+2):0)
     * 状态数组：dp[n+1]
     * 状态方程：f[n] = f[n+1]+ s[n+1]+s[n+2]<=26? f[n+2]:0
     *
     * @param s
     * @return
     */
    public static int numDecodingsByDp(String s) {
        int length = s.length();
        int[] dp = new int[length + 1];
        dp[length] = 1;
        if (s.charAt(length - 1) != '0') {
            dp[length - 1] = 1;
        }
        for (int i = length - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                continue;
            }
            int ans1 = dp[i + 1];
            int ans2 = 0;
            int ten = (s.charAt(i) - '0') * 10;
            int one = s.charAt(i + 1) - '0';
            if (ten + one <= 26) {
                ans2 = dp[i + 2];
            }
            dp[i] = ans1 + ans2;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(LeetCode_91_202.numDecodingsByRecursive("226"));
        System.out.println(LeetCode_91_202.numDecodingsByDp("226"));
    }

}
