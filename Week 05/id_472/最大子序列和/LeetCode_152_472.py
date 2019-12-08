#!/usr/bin/python
# -*- coding: utf-8 -*-
# @Time    : 2019/11/23
# @Author  : xujun
"""
152. 乘积最大子序列
给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
"""


class Solution:
    def maxProduct(self, nums) -> int:
        dp_max = nums[0]
        dp_min = nums[0]
        c_max = nums[0]
        for num in nums[1:]:
            pre_max = dp_max
            dp_max = max(dp_max * num, dp_min * num, num)
            dp_min = min(pre_max * num, dp_min * num, num)
            c_max = max(dp_max, c_max)
        return c_max
