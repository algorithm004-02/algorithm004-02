#!/usr/bin/python
# -*- coding: utf-8 -*-
# @Time    : 2019/11/24
# @Author  : xujun
"""
198. 打家劫舍
你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
"""


# class Solution:
#     def rob(self, nums) -> int:
#         if len(nums) == 0:
#             return 0
#         if len(nums) <= 2:
#             return max(nums)
#         a = nums[0]
#         b = max(nums[0], nums[1])
#         for i in range(2, len(nums)):
#             c = max(nums[i] + a, b)
#             a, b = b, c
#         return c

class Solution:
    def rob(self, nums) -> int:
        cur, pre = 0, 0
        for num in nums:
            cur, pre = max(pre + num, cur), cur
        return cur
