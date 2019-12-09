package app.homeworkWeekEighth;
/*
 * @lc app=leetcode id=91 lang=java
 *
 * [91] Decode Ways
 *
 * https://leetcode.com/problems/decode-ways/description/
 *
 * algorithms
 * Medium (23.03%)
 * Likes:    1881
 * Dislikes: 2135
 * Total Accepted:    319.7K
 * Total Submissions: 1.4M
 * Testcase Example:  '"12"'
 *
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping:
 * 
 * 
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 
 * 
 * Given a non-empty string containing only digits, determine the total number
 * of ways to decode it.
 * 
 * Example 1:
 * 
 * 
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2
 * 6).
 * 
 */

// @lc code=start
class Solution {
    /**
     * 动态规划dp[i]保存长度为i时，可解码的数量
     * 当长度为i时，i>=2; 
     * 如果(i-1,i)在范围1<=x<=9,则dp[i]有dp[i-1]种解码sum1
     * 如果(i-2,i)在范围10<=x<=26,则dp[i]有dp[i-2]种解码sum2;
     * dp[i] = sum1 + sum2;
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int size = s.length();
        int [] dp = new int [size + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= size; i++) {
            int first = Integer.valueOf(s.substring(i - 1, i)), firstSum = 0;
            int second = Integer.valueOf(s.substring(i - 2, i)), secondSum = 0;
            if (1 <= first && first <= 9) firstSum = dp[i - 1];
            if (10 <= second && second <= 26) secondSum = dp[i - 2];
            dp[i] = firstSum + secondSum;
        }
        return dp[size];
    }
}
// @lc code=end

