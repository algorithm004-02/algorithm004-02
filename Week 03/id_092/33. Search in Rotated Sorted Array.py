#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
@Time : 2019/10/30 下午3:42
@Author : Catherinexxx
@Site : 
@File : 33. Search in Rotated Sorted Array.py
@Software: PyCharm
"""


# 二分查找
# # 中间元素和右边界比较，使用右中位数
# class Solution:
#     def search(self, nums, target):
#         size = len(nums)
#         if size == 0:
#             return -1

#         left = 0
#         right = size - 1
#         while left < right:
#             # mid = left + (right - left + 1) // 2
#             mid = (left + right + 1) >> 1
#             if nums[mid] < nums[right]:
#                 # [7,8,9,1,2,3,4,5,6] ，后半部分有序
#                 if nums[mid] <= target <= nums[right]:
#                     left = mid
#                 else:
#                     right = mid - 1
#             else:
#                 # 注意：写这个 if 语句的时候，要让分支和上面一样
#                 # [4,5,6,7,8,9,0,1,2]，前半部分有序
#                 if nums[left] <= target <= nums[mid - 1]:
#                     right = mid - 1
#                 else:
#                     left = mid
#         # 后处理
#         return left if nums[left] == target else -1

class Solution:
    def search(self, nums, target):
        lo, hi = 0, len(nums)

        while lo < hi:
            mid = (lo + hi) // 2

            if (nums[mid] < nums[0]) == (target < nums[0]):
                # mid 和 target在同一边 之后正常二分查找
                if (nums[mid] < target):
                    lo = mid + 1
                elif (nums[mid] > target):
                    hi = mid
                else:
                    return mid
            elif target < nums[0]:
                # target在右 mid在左
                lo = mid + 1
            else:
                # target在左 mid在右
                hi = mid

        return -1