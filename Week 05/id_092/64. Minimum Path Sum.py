#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
@Time : 2019/11/15 下午2:40
@Author : Catherinexxx
@Site : 
@File : 64. Minimum Path Sum.py
@Software: PyCharm
"""

# DP
# s[i,j] = min(s[i,j-1]+s[i,j],s[i+1,j]+s[i,j]) s[-1][-1]
# 状态数组加一行一列辅助
class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        dp = [[float('inf')] * (len(grid[0])+1)] + [[float('inf')]+i for i in grid]
        dp[0][1], dp[1][0] = 0, 0
        for i in range(1, len(grid)+1):
            for j in range(1,len(grid[0])+1):
                dp[i][j] += min(dp[i][j-1], dp[i-1][j])
        return dp[-1][-1]