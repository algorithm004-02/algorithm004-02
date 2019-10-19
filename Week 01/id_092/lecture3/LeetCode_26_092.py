#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
@Time : 2019/10/16 下午1:52
@Author : Catherinexxx
@Site : 
@File : remove-duplicates-from-sorted-array.py
@Software: PyCharm
"""
# 双指针
class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        n = 0
        i, j = 0, 1
        while j < len(nums):
            if nums[i] == nums[j]:
                n += 1
                j += 1
            else:
                nums[i+1] = nums[j]
                i += 1
                j += 1
        return len(nums) - n