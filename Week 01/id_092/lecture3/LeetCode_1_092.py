#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
@Time : 2019/10/16 下午1:49
@Author : Catherinexxx
@Site : 
@File : two-sum.py
@Software: PyCharm
"""


# # 1.暴力遍历
# class Solution:
#     def twoSum(self, nums: List[int], target: int) -> List[int]:
#         res = [0, 0]
#         for i, a in enumerate(nums):
#             tmp = target - a
#             for j in range(i+1, len(nums)):
#                 if nums[j] == tmp:
#                     res = [i, j]
#                     return res

# 2. hashmap
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hashmap = {}
        for i, x in enumerate(nums):
            hashmap[x] = i
        for i, x in enumerate(nums):
            tmp = target - x
            j = hashmap.get(tmp)
            if j is not None and i != j:
                return [i, j]
