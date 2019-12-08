#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
@Time : 2019/11/12 下午1:06
@Author : Catherinexxx
@Site : 
@File : 1143. Longest Common Subsequence.py
@Software: PyCharm
"""
# 1、暴力递归生成一个的子序列 后在另一个中判断是否存在 O(2^n)
# dp
class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        if not text1 or not text2:
            return 0
        m = len(text1)
        n = len(text2)
        dp = [[0]*(n+1) for _ in range(m+1)]
        for i in range(1, m+1):
            for j in range(1, n+1):
                if text1[i-1] == text2[j-1]:
                    dp[i][j] = 1 + dp[i-1][j-1]
                else:
                    dp[i][j] = max(dp[i-1][j], dp[i][j-1])
        return dp[m][n]