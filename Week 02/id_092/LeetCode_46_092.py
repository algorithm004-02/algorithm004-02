#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
@Time : 2019/10/26 下午5:17
@Author : Catherinexxx
@Site : 
@File : 46.permutations.py
@Software: PyCharm
"""
class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        res = []
        def backtrack(nums, tmp):
            if not nums:
                res.append(tmp)
                return
            for i in range(len(nums)):
                backtrack(nums[:i] + nums[i+1:], tmp + [nums[i]])
        backtrack(nums, [])
        return res