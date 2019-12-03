#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
@Time : 2019/11/17 下午5:55
@Author : Catherinexxx
@Site : 
@File : 221. Maximal Square.py
@Software: PyCharm
"""


# m[i][j+1] m[i+1][j] m[i+1][j+1]
# # 1、暴力法
# class Solution:
#     def maximalSquare(self, matrix: List[List[str]]) -> int:
#         sqlen, maxsql = 0, 0

#         for i in range(len(matrix)):
#             for j in range(len(matrix[0])):
#                 if matrix[i][j] == 1:
#                     sqlen = 1
#                     flag = True
#                     while sqlen + i < len(matrix) and sqlen + j < len(matrix[0]) and flag:
#                         for k in range(i, sqlen + i +1):
#                             if matrix[k][sqlen + j] == 0:
#                                 flag = False
#                                 break

#                         for k in range(j, sqlen + j +1):
#                             if matrix[sqlen + i][k] == 0:
#                                 flag = False
#                                 break

#                         sqlen += 1
#                     maxsql = max(maxsql, sqlen)
#         return maxsql*maxsql

# DP
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if not matrix: return 0
        row = len(matrix)
        col = len(matrix[0])
        dp = [[0] * (col + 1) for _ in range(row + 1)]
        res = 0
        for i in range(1, row + 1):
            for j in range(1, col + 1):
                if matrix[i - 1][j - 1] == "1":
                    dp[i][j] = min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]) + 1
                    res = max(res, dp[i][j] ** 2)
        return res
