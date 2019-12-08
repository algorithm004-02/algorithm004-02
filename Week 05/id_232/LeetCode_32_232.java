package src.main.java.com.fans.algorithm00402.week5.homework;

import java.util.Stack;

/**
 * 有小括号的最大长度
 */
public class LeetCode_32_232 {

    /**
     * 暴力法
     */
//    public int longestValidParentheses(String s) {
//        if (s.length() == 1) return 0;
//        int max = 0;
//        for (int i = 0; i < s.length() - 1; i ++) {
//            for (int j = i + 2; j <= s.length(); j += 2){
//                if (helper(s.substring(i, j))) {
//                    max = Math.max(j - i, max);
//                }
//            }
//        }
//        return max;
//    }
//
//    private boolean helper(String substring) {
//        char[] chars = substring.toCharArray();
//        Stack<Character> stack = new Stack<>();
//
//        for (int i = 0; i < chars.length; i ++) {
//            if (chars[i] == '(') stack.push(chars[i]);
//            else if (!stack.isEmpty() && stack.peek() == '(') stack.pop();
//            else return false;
//        }
//        return stack.isEmpty();
//    }


    /**
     * dp
     *  a. 子问题
     *      - s[i] == ')' && s[i - 1] == '('
     *          括号匹配成功
     *          f(i) = f(n - 2) + 2;
     *      - s[i] == ')' && s[i - 1] == ')'
     *          有可能括号匹配ok
     *          f(i) = f(n - 1) + f(i - f(n - 1) - 2) + 2;
     *  b. dp 数组
     *      - dp[n]
     *  c. dp 方程
     *      - s[i] == ')' && s[i - 1] == '('
     *          括号匹配成功
     *          dp[i] = dp[n - 2] + 2;
     *      - s[i] == ')' && s[i - 1] == ')'
     *          有可能括号匹配ok
     *         dp[i] = dp[n - 1] + dp[i - dp[n - 1] - 2] + 2;
     */
    public int longestValidParentheses(String s) {
        char[] chars = s.toCharArray();
        if (chars.length < 2) return 0;
        int[] dp = new int[chars.length];
        int max = 0;
        for (int i = 1; i < chars.length; i ++) {
            if (chars[i] == ')') {
                if (chars[i - 1] == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && chars[i - dp[i - 1] - 1] == '(') {
                    dp[i] = dp[i - 1] + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                max = Math.max(dp[i], max);
            }
        }
        return max;
    }
}
