#!/usr/bin/python
# -*- coding: utf-8 -*-
# @Time    : 2019/11/8
# @Author  : xujun
"""
给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
"""


class Solution:
    def threeSum(self, nums):
        length = len(nums)
        if length < 3:
            return None
        a = []
        nums.sort()
        tail = length - 1
        for i in range(length):
            if nums[i] > 0:
                return a
            if i > 0 & nums[i] == nums[i-1]:
                continue
            j = i + 1
            while j < tail:
                sum = nums[i] + nums[j] + nums[tail]
                if sum == 0:
                    a.append([nums[i], nums[j], nums[tail]])
                    break
                elif sum > 0:
                    tail -= 1
                else:
                    j += 1
        return a


nums = [-1, 0, 1, 2, -1, -4]
s = Solution()
a = s.threeSum(nums)
print(a)
