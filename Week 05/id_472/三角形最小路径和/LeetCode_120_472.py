#!/usr/bin/python
# -*- coding: utf-8 -*-
# @Time    : 2019/11/23
# @Author  : xujun
"""
三角形最小路径和
给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。

例如，给定三角形：

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。

"""


# 动态规划，自底向上编程
# class Solution:
#     def minimumTotal(self, triangle) -> int:
#         for i in range(len(triangle)-2, -1, -1):
#             for j in range(len(triangle[i])):
#                 triangle[i][j] = min(triangle[i+1][j], triangle[i+1][j+1]) + triangle[i][j]
#         return triangle[0][0]


# 动态规划，自底向上编程, 降维
class Solution:
    def minimumTotal(self, triangle) -> int:
        dp = triangle[-1]
        for i in range(len(triangle) - 2, -1, -1):
            for j in range(len(triangle[i])):
                dp[j] = min(dp[j], dp[j + 1]) + triangle[i][j]
        return dp[0]
