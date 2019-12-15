#!/usr/bin/python
# -*- coding: utf-8 -*-
# @Time    : 2019/10/20
# @Author  : xujun
class Solution:
    def removeDuplicates(self, nums: list) -> int:
        if len(nums) == 0:
            return 0
        i = 0
        for j in range(1, len(nums)):
            if nums[i] != nums[j]:
                i += 1
                nums[i] = nums[j]
        return i + 1


solution = Solution()
a = [0, 1, 1, 1, 2, 3, 3, 5, 6]
length = solution.removeDuplicates(a)
print(length)
