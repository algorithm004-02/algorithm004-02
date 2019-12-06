#!/usr/bin/python
# -*- coding: utf-8 -*-
# @Time    : 2019/11/23
# @Author  : xujun
"""
最大子序和
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
"""
class Solution:
    def maxSubArray(self, nums) -> int:
        tmp = nums[0]
        res = tmp
        for num in nums[1:]:
            tmp = max(tmp, 0) + num
            res = max(tmp, res)
        return res
