#!/usr/bin/python
# -*- coding: utf-8 -*-
# @Time    : 2019/12/8
# @Author  : xujun
"""
300. 最长上升子序列
给定一个无序的整数数组，找到其中最长上升子序列的长度。
"""

class Solution:
    def lengthOfLIS(self, nums) -> int:
        if len(nums) == 0:
            return 0
        dp = [1] * len(nums)
        cur_max = 1
        for i in range(1, len(nums)):
            for j in range(i):
                if nums[i] > nums[j]:
                    dp[i] = max(dp[i], dp[j] + 1)
            cur_max = max(cur_max, dp[i])
        return cur_max
