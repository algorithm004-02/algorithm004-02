package com.algorithm.qinchao.homework.week05;

import java.util.Stack;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/11/16 16:45
 * @description
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * 示例 1:
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_32_202 {

    public static int longestValidParenthesesByStack(String s) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }

    /**
     * 将值更新在)对应的位置上
     * 子问题：...i.() f(i) = f(i-2)+2       ......)) f(i) = f(i-1)+ f(i-f(i-1)-2) +2
     * 状态函数：dp[n]
     * dp方程：f[i] = f[i-2]+2       ......)) f[i] = f[i-1]+ f[i-f[i-1]-2] +2
     * @param s
     * @return
     */
    public static int longestValidParenthesesByDp(String s) {
        int max = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            //当前的
            if (s.charAt(i) == ')') {
                //前一个是的画，凑成一对了，但是如果不是大于2的话有可能被间断的，所以还是0吧，如果是大于2，就要看前面有没有间断，没间断的话，dp(i-2)肯定有值，不然取了还是0,。
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                    //如果是前面一个是），就看他的前面是（还是）了，
                    // (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(')
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        System.out.println(LeetCode_32_202.longestValidParenthesesByStack("()()"));
        System.out.println(LeetCode_32_202.longestValidParenthesesByStack(")()())"));
        System.out.println(LeetCode_32_202.longestValidParenthesesByStack("()(()"));
        System.out.println(LeetCode_32_202.longestValidParenthesesByStack("()(()()"));
        System.out.println(LeetCode_32_202.longestValidParenthesesByDp("()(()(()"));
        System.out.println(LeetCode_32_202.longestValidParenthesesByDp("(((())))"));
    }
}
