package app.homeworkWeekEighth;

/*
 * @lc app=leetcode id=32 lang=java
 *
 * [32] Longest Valid Parentheses
 *
 * https://leetcode.com/problems/longest-valid-parentheses/description/
 *
 * algorithms
 * Hard (26.52%)
 * Likes:    2539
 * Dislikes: 111
 * Total Accepted:    233.1K
 * Total Submissions: 868.4K
 * Testcase Example:  '"(()"'
 *
 * Given a string containing just the characters '(' and ')', find the length
 * of the longest valid (well-formed) parentheses substring.
 * 
 * Example 1:
 * 
 * 
 * Input: "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()"
 * 
 * 
 */

// @lc code=start
class Solution {
    /**
     * 动态规划，参考的题解https://leetcode-cn.com/problems/longest-valid-parentheses/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-7/
     * 示例参数()()(())
     *
     * Time O(n)
     * Space O(n)
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        if (s == null || s.length() <= 1) return 0;
        int [] dp = new int [s.length()];
        int maxValid = 0;
        for (int i = 1; i < dp.length; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = i >= 2 ? dp[i - 2] + 2 : 2;//()()
                } else if ((i - dp[i - 1] > 0) && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
            }
            maxValid = Math.max(maxValid, dp[i]);
        }
        return maxValid;
    }
}
// @lc code=end

