#!/usr/bin/python
# -*- coding: utf-8 -*-
# @Time    : 2019/10/20
# @Author  : xujun
nums = [1, 2, 3, 4, 5, 6, 7]
k = 4


# 暴力
# 最简单的方法是旋转 k 次，每次将数组旋转 1 个元素。
# class Solution(object):
#     def rotate(self, nums, k):
#         """
#         :type nums: List[int]
#         :type k: int
#         :rtype: None Do not return anything, modify nums in-place instead.
#         """
#         for i in range(k):
#             prev = nums[-1]
#             for j in range(len(nums)):
#                 temp = nums[j]
#                 nums[j] = prev
#                 prev = temp


# 使用额外的数组
# class Solution(object):
#     def rotate(self, nums, k):
#         a = [None] * len(nums)
#         for i in range(len(nums)):
#             a[(i + k) % len(nums)] = nums[i]
#         for j in range(len(nums)):
#             nums[j] = a[j]


# TODO使用环状替换
# class Solution(object):
#     def rotate(self, nums, k):
#         k = k % len(nums)
#         for i in range(len(nums)):
#             while
#             next = (i + k) % len(nums)
#             temp = nums[next]
#             nums[next] = nums[i]


# 使用反转
class Solution(object):
    def rotate(self, nums, k):
        k %= len(nums)
        self._reverse(nums, 0, len(nums) - 1)
        self._reverse(nums, 0, k - 1)
        self._reverse(nums, k, len(nums) - 1)

    def _reverse(self, nums, start, end):
        while (start < end):
            temp = nums[start]
            nums[start] = nums[end]
            nums[end] = temp
            start += 1
            end -= 1


solution = Solution()
solution.rotate(nums, k)
print(nums)
