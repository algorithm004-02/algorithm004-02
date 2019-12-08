#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
@Time : 2019/11/20 上午11:01
@Author : Catherinexxx
@Site : 
@File : 51.N queens.py
@Software: PyCharm
"""

class Solution:
    def solveNQueens(self, n):
        def DFS(queens, xy_dif, xy_sum):
            """
            temp = [["." * i + "Q" + "." * (n - i - 1) for i in queens]]
            for t in temp:
                for tt in t:
                    print(tt)
                print("\n")
            print("\n")
            """

            p = len(queens)  # p is the index of row
            if p == n:
                result.append(queens)
                return None
            for q in range(n):  # q is the index of col
                # queens stores those used cols, for example, [0,2,4,1] means these cols have been used
                # xy_dif is the diagonal 1
                # xy_sum is the diagonal 2

                # 不在同列、 不在撇、 不在捺
                if q not in queens and p - q not in xy_dif and p + q not in xy_sum:
                    DFS(queens + [q], xy_dif + [p - q], xy_sum + [p + q])

        result = []
        DFS([], [], [])
        return [["." * i + "Q" + "." * (n - i - 1) for i in sol] for sol in result]

# # 位运算 不是很懂
# class Solution(object):
#     def totalNQueens(self, n):
#         if n < 1: return []
#         self.count = 0
#         self.DFS(n, 0, 0, 0, 0)
#         return self.count
#
#     def DFS(self, n, row, cols, pie, na):
#         # recursion terminator
#         if row >= n:
#             self.count += 1
#             return
#
#         bits = (~(cols | pie | na)) & ((1 << n) — 1)  # 得到当前所有的空位
#
#         while bits:
#             p = bits & —bits  # 取到最低位的1
#             bits = bits & (bits — 1)  # 表示在p位置上放入皇后
#             self.DFS(n, row + 1, cols | p, (pie | p) << 1, (na | p) >> 1)
#             # 不需要revert  cols, pie, na 的状态
