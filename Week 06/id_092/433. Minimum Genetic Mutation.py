#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
@Time : 2019/11/21 上午11:24
@Author : Catherinexxx
@Site : 
@File : 433. Minimum Genetic Mutation.py
@Software: PyCharm
"""


# # 双向BFS
# class Solution:
#     def minMutation(self, start: str, end: str, bank: List[str]) -> int:
#         if end not in bank:return -1
#         front = {start}
#         back = {end}
#         dist = 0
#         bank = set(bank)

#         while front and back:
#             dist += 1
#             next_front = set()
#             for gene in front:
#                 for i in range(len(start)):
#                     for c in ['A','C','G','T']:
#                         cur = gene[:i] + c + gene[i+1:]
#                         if cur in back: return dist
#                         if cur in bank:
#                             next_front.add(cur)
#                             bank.remove(cur)    # 防止走重复的路

#             front = next_front
#             if len(back) < len(front):
#                 front, back = back, front

#         return -1

# BFS
class Solution:
    def minMutation(self, start: str, end: str, bank: List[str]) -> int:
        if end not in bank: return -1
        front = {start}
        # back = {end}
        dist = 0
        bank = set(bank)

        while front:
            dist += 1
            next_front = set()
            for gene in front:
                for i in range(len(start)):
                    for c in ['A', 'C', 'G', 'T']:
                        cur = gene[:i] + c + gene[i + 1:]
                        if cur == end: return dist
                        if cur in bank:
                            next_front.add(cur)
                            bank.remove(cur)  # 防止走重复的路

            front = next_front
            # if len(back) < len(front):
            #     front, back = back, front

        return -1