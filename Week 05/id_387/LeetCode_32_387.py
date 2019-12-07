# https://leetcode.com/problems/longest-valid-parentheses/
# 32. Longest Valid Parentheses
class Solution:
  def longestValidParentheses(self, s: str) -> int:
    res = 0
    n = len(s)
    dp = [0] * n
    for i in range(1, n):
      if s[i] == ")":
        if s[i-1] == "(":
          dp[i] = dp[i-2] + 2
        elif i - dp[i-1] > 0 and s[i-dp[i-1]-1] == "(":
          dp[i] = dp[i-1] + dp[i-dp[i-1]-2] + 2
        res = max(res, dp[i])
    return res