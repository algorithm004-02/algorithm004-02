#!/usr/bin/python
# -*- coding: utf-8 -*-
# @Time    : 2019/11/24
# @Author  : xujun
"""
213. 打家劫舍 II
你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
"""


# class Solution:
#     def rob(self, nums) -> int:
#         length = len(nums)
#         if length == 0:
#             return 0
#         if length <= 3:
#             return max(nums)
#         dp1 = [0] * (length - 1)
#         dp1[0] = nums[0]
#         dp1[1] = max(nums[0], nums[1])
#         for i in range(2, length - 1):
#             dp1[i] = max(dp1[i - 2] + nums[i], dp1[i - 1])
#
#         dp2 = [0] * (length - 1)
#         dp2[0] = nums[1]
#         dp2[1] = max(nums[1], nums[2])
#         for j in range(3, length):
#             dp2[j - 1] = max(dp2[j - 3] + nums[j], dp2[j - 2])
#         print(max(dp1[-1], dp2[-1]))
#         return max(dp1[-1], dp2[-1])


class Solution:
    def rob(self, nums: [int]) -> int:
        def my_rob(nums):
            cur, pre = 0, 0
            for num in nums:
                cur, pre = max(pre + num, cur), cur
            return cur

        return max(my_rob(nums[:-1]), my_rob(nums[1:])) if len(nums) != 1 else nums[0]
