#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
@Time : 2019/10/16 下午12:09
@Author : Catherinexxx
@Site : 
@File : move-zeros.py
@Software: PyCharm
"""

# python


class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        j = 0
        for i in range(len(nums)):
            if nums[i] != 0:
                nums[j] = nums[i]
                if i != j:
                    nums[i] = 0
                j += 1

# // java
# class Solution {
#     public void moveZeroes(int[] nums) {
#         int j = 0;
#         for (int i = 0; i < nums.length; ++i) {
#             if (nums[i] != 0) {
#                 nums[j] = nums[i];
#                 if (i != j) {
#                     nums[i] = 0;
#                 }
#                 j++;
#             }
#         }
#     }
# }