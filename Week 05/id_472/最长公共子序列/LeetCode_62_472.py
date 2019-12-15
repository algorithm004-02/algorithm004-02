#!/usr/bin/python
# -*- coding: utf-8 -*-
# @Time    : 2019/11/18
# @Author  : xujun
"""
不同路径
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

问总共有多少条不同的路径？
"""


# 动态规划
# dp[i][j] = dp[i-1][j] + dp[i][j-1]
# 时间复杂度O(m*n)的解法
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [[1] * n] + [[1] + [0] * (n - 1) for _ in range(1, m)]
        for i in range(1, m):
            for j in range(1, n):
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        return dp[-1][-1]

# 时间复杂度O(n)的解法
# class Solution:
#     def uniquePaths(self, m: int, n: int) -> int:
#         rows = [1] * m
#         for i in range(1, n):
#             for j in range(1, m):
#                 rows[j] = rows[j-1] + rows[j]
#         return rows[-1]
