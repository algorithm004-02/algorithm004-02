#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
@Time : 2019/10/29 下午2:26
@Author : Catherinexxx
@Site : 
@File : 55. Jump Game.py
@Software: PyCharm
"""

# 贪心算法 从后往前
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        jump = len(nums)-1
        for i in range(len(nums)-2, -1, -1):
            if nums[i] + i >= jump:jump = i     # if写在一行速度提高
        return jump == 0

