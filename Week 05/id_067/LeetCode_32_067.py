#
# @lc app=leetcode.cn id=32 lang=python3
#
# [32] 最长有效括号
#

# @lc code=start
class Solution:
    def longestValidParentheses(self, s: str) -> int:
        if s is None:
            return 0
        dp = [0] * (len(s) + 1)
        stack = []
        for i in range(len(s)):
            if s[i] == '(':
                stack.append(i)
            else:
                if len(stack) > 0:
                    p = stack.pop()
                    dp[i + 1] = dp[p] + i - p + 1
        return max(dp)

"""
# use stack
    def longestValidParentheses(self, s: str) -> int:
        if s is None:
            return 0
        maxans = 0
        stack = []
        stack.append(-1)
        for i in range(len(s)):
            if s[i] == "(":
                stack.append(i)
            else:
                stack.pop()
                if stack == []:
                    stack.append(i)
                else:
                    maxans = max(maxans, i - stack[-1])
        return maxans
"""
        
# @lc code=end

