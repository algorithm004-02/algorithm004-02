/*
 * @lc app=leetcode.cn id=647 lang=java
 *
 * [647] 回文子串
 *
 * https://leetcode-cn.com/problems/palindromic-substrings/description/
 *
 * algorithms
 * Medium (58.90%)
 * Likes:    150
 * Dislikes: 0
 * Total Accepted:    11.6K
 * Total Submissions: 19.7K
 * Testcase Example:  '"abc"'
 *
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * 
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 * 
 * 示例 1:
 * 
 * 
 * 输入: "abc"
 * 输出: 3
 * 解释: 三个回文子串: "a", "b", "c".
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: "aaa"
 * 输出: 6
 * 说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
 * 
 * 
 * 注意:
 * 
 * 
 * 输入的字符串长度不会超过1000。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int countSubstrings(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int ret = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (isPalindrome(s, i, j)) {
                    ++ret;
                }
            }
        }
        return ret;
    }

    boolean isPalindrome(String s, int i, int j) {
        while (i <= j) {
            if (s.charAt(i++) != s.charAt(j--))
                return false;
        }
        return true;
    }
}
// @lc code=end
