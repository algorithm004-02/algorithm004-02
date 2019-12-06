#!/usr/bin/python
# -*- coding: utf-8 -*-
# @Time    : 2019/11/30
# @Author  : xujun
class Solution:
    def longestValidParentheses(self, s: str) -> int:
        ans = 0
        dp = [0] * len(s)
        for i in range(1, len(s)):
            if s[i] == ')':
                if s[i - 1] == '(':
                    dp[i] = (dp[i - 2] if i >= 2 else 0) + 2
                    print('{}: {}'.format(i, dp[i]))
                elif (((i - dp[i - 1]) > 0) and (s[i - dp[i - 1] - 1] == '(')):
                    dp[i] = dp[i - 1] + (dp[i - dp[i - 1] - 2] if (i - dp[i - 1]) >= 0 else 0) + 2
            ans = max(ans, dp[i])
        return ans
