/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 * <p>
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 */

//动态规划
class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int result = 0;
        char[] arr = s.toCharArray();
        int[] temp = new int[arr.length];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == ')') {
                if (arr[i - 1] == '(') {
                    temp[i] = (i >= 2 ? temp[i - 2] : 0) + 2;
                } else if (i - temp[i - 1] > 0 && arr[i - temp[i - 1] - 1] == '(') {
                    temp[i] = 2 + temp[i - 1] + (i - temp[i - 1] >= 2 ? temp[i - temp[i - 1] - 2] : 0);
                }
                result = Math.max(result, temp[i]);
            }
        }
        return result;
    }
}

//栈解决
class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int result = 0;
        char[] arr = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    result = Math.max(result, i - stack.peek());
                }
            }
        }
        return result;
    }
}