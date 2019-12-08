package app.homeworkWeekTwo;

import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 *
 * https://leetcode.com/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (57.54%)
 * Likes:    3480
 * Dislikes: 206
 * Total Accepted:    412K
 * Total Submissions: 713.4K
 * Testcase Example:  '3'
 *
 * 
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * 
 * 
 * For example, given n = 3, a solution set is:
 * 
 * 
 * [
 * ⁠ "((()))",
 * ⁠ "(()())",
 * ⁠ "(())()",
 * ⁠ "()(())",
 * ⁠ "()()()"
 * ]
 * 
 */

// @lc code=start
class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesis_recursion(n, 0, 0, "", result);
        return result;
    }

    /**
     * left < n，可插入左括号
     * left > right，可插入右括号
     * 时间复杂度O(2^n)
     * @param n 左右括号分别的个数
     * @param left 当前左括号个数
     * @param right 当前右括号个数
     * @param str
     * @param result
     * @return
     */
    private void generateParenthesis_recursion(int n, int left, int right, String str, List<String> result) {
        if (left == n && right == n) {
            result.add(str);
        } else {
            if (left < n) {
                generateParenthesis_recursion(n, left + 1, right, str + "(", result);
            }

            if (left > right) {
                generateParenthesis_recursion(n, left, right + 1, str + ")", result);
            }
        }
    }



    /**
     * 使用递归求出所有可能的组合，然后通过stack校验是否合法，(括号入栈，)括号则把(括号出栈，如果栈为空则直接不正确
     */
}
// @lc code=end

