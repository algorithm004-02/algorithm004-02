#!/usr/bin/python
# -*- coding: utf-8 -*-
# @Time    : 2019/11/7
# @Author  : xujun
"""
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
"""


# 暴力求解：时间复杂度 O(n), 空间复杂度:O(n)
# class Solution:
#     def moveZeroes(self, nums):
#         """
#         Do not return anything, modify nums in-place instead.
#         """
#         store = []
#         for num in nums:
#             if num != 0:
#                 store.append(num)
#         diff = len(nums) - len(store)
#         store.extend([0] * diff)
#         return store


# 双指针
# class Solution:
#     def moveZeroes(self, nums):
#         i = 0
#         for num in nums:
#             if num != 0:
#                 nums[i] = num
#                 i += 1
#
#         for i in range(i, len(nums)):
#             nums[i] = 0
#         return nums

# 双指针
class Solution:
    def moveZeroes(self, nums):
        i = 0
        for j in range(len(nums)):
            if nums[j] != 0:
                nums[i] = nums[j]
                nums[j] = 0
                i += 1
        return nums


a = [0, 1, 0, 3, 12]
s = Solution()
b = s.moveZeroes(a)
print(b)
