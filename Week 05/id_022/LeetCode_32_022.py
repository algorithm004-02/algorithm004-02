#[32]最长有效括号
#
#给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
#
# 示例 1: 
#
# 输入: "(()"
#输出: 2
#解释: 最长有效括号子串为 "()"
# 
#
# 示例 2: 
#
# 输入: ")()())"
#输出: 4
#解释: 最长有效括号子串为 "()()"
# 
# Related Topics 字符串 动态规划


class Solution:

    def longestValidParentheses(self, s: str) -> int:

        if not s or len(s) < 2:
            return 0

        dp = [0] * len(s)
        dp[1] = 2 if s[0] == '(' and s[1] == ')' else 0

        for i in range(2, len(s)):
            if s[i] == ')':
                if s[i - 1] == '(':
                    dp[i] = dp[i - 2] + 2
                else:
                    j = i - dp[i - 1] - 1
                    if j >= 0 and s[j] == '(':
                        dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 2] if j > 0 else 0

        return max(dp)
