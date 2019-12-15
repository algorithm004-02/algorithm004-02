package app.homeworkWeekFifth;
/*
 * @lc app=leetcode id=1143 lang=java
 *
 * [1143] Longest Common Subsequence
 *
 * https://leetcode.com/problems/longest-common-subsequence/description/
 *
 * algorithms
 * Medium (57.34%)
 * Likes:    343
 * Dislikes: 8
 * Total Accepted:    20.8K
 * Total Submissions: 36.4K
 * Testcase Example:  '"abcde"\n"ace"'
 *
 * Given two strings text1 and text2, return the length of their longest common
 * subsequence.
 * 
 * A subsequence of a string is a new string generated from the original string
 * with some characters(can be none) deleted without changing the relative
 * order of the remaining characters. (eg, "ace" is a subsequence of "abcde"
 * while "aec" is not). A common subsequence of two strings is a subsequence
 * that is common to both strings.
 * 
 * 
 * 
 * If there is no common subsequence, return 0.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: text1 = "abcde", text2 = "ace" 
 * Output: 3  
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no such common subsequence, so the result is 0.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= text1.length <= 1000
 * 1 <= text2.length <= 1000
 * The input strings consist of lowercase English characters only.
 * 
 * 
 */

// @lc code=start
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        return longestCommonSubsequence_dp(text1, text2);
    }

    /**
     * 动态规划
     * dp方程定义：两个字符串靠右排列，
     * 如果右侧相同，那么最长子序列为(substringtext1 与substringtext2的最长子序列）+ 1,
     * 如果右侧不同，那么最长子序列为(substringtext1 与substringtext2的最长子序列）+ 0
     * 时间复杂度O(m*n)
     * 空间复杂度O(m*n)
     * @param text1
     * @param text2
     * @return
     */
    private int longestCommonSubsequence_dp(String text1, String text2) {
        if (!(text1 == null || text2 == null || text1.equals("") || text2.equals(""))) {
            int [][] cache = new int[text2.length() + 1][text1.length() + 1];
            for (int i = 1; i <= text2.length(); i++) {
                for (int j = 1; j <= text1.length(); j++) {
                    if (text1.charAt(j - 1) == text2.charAt(i - 1)) {
                        cache [i][j] = cache[i - 1][j - 1] + 1;
                    } else {
                        cache [i][j] = Math.max(cache[i][j - 1], cache[i - 1][j]);
                    }
                }
            }
            return cache[text2.length()] [text1.length()];
        }
        return 0;
    }
}
// @lc code=end

