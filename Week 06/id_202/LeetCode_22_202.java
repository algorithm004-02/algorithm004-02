package com.algorithm.qinchao.homework.week06;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/11/20 19:31
 * @description 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 例如，给出 n = 3，生成结果为：
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_22_202 {
    public static List<String> generateParenthesisByRecursive(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        int max = 2 * n;
        recursive(max, 0, 0, result, n, "");
        return result;
    }

    private static void recursive(int max, int open, int close, List<String> result, int n, String cur) {
        if (max == open + close) {
            result.add(cur);
            return;
        }
        if (open < n) {
            recursive(max, open + 1, close, result, n, cur + "(");
        }
        if (close < n && close < open) {
            recursive(max, open, close + 1, result, n, cur + ")");
        }
    }

    /**
     * 子问题：f(i) = (f(i-1))  + f(n-i-1)
     *
     * @param n
     * @return
     */
    public static List<String> generateParenthesisByDp(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }
        List<List<String>> dp = new ArrayList<>();
        List<String> dp0 = new ArrayList<>();
        dp0.add("");
        dp.add(dp0);
        for (int i = 1; i <= n; i++) {
            List<String> curr = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                List<String> strs1 = dp.get(j);
                List<String> strs2 = dp.get(i - j - 1);
                for (String str1 : strs1) {
                    for (String str2 : strs2) {
                        curr.add("(" + str1 + ")" + str2);
                    }
                }
            }
            dp.add(curr);
        }
        return dp.get(n);
    }

    public static void main(String[] args) {
        System.out.println(LeetCode_22_202.generateParenthesisByRecursive(3));
        System.out.println(LeetCode_22_202.generateParenthesisByDp(3));
    }
}
