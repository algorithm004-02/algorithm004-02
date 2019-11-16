#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
@Time : 2019/10/26 下午4:23
@Author : Catherinexxx
@Site : 
@File : 77.combinations.py
@Software: PyCharm
"""


# # 回溯
# class Solution:
#     def combine(self, n: int, k: int) -> List[List[int]]:
#         res = []
#         def combine(next, cur):
#             if len(cur) == k:
#                 res.append(cur[:])
#                 return
#             for i in range(next, n+1):
#                 cur.append(i)
#                 combine(i+1, cur)
#                 cur.pop()
#         combine(1, [])
#         return res

# super fast
class Solution:
    def combine(self, n, k):
        if k == 0:
            return [[]]
        return [pre + [i] for i in range(k, n + 1) for pre in self.combine(i - 1, k - 1)]