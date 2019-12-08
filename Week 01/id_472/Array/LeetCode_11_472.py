#!/usr/bin/python
# -*- coding: utf-8 -*-
# @Time    : 2019/11/7
# @Author  : xujun
"""
给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 
(i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
"""


# 暴力求解
# class Solution:
#     def maxArea(self, height) -> int:
#         max_area = 0
#         for i, h1 in enumerate(height):
#             for j, h2 in enumerate(height[i + 1:]):
#                 area = (j + i + 1 - i) * min(h1, h2)
#                 max_area = max(max_area, area)
#         return max_area


# 双指针
class Solution:
    def maxArea(self, height) -> int:
        head = 0
        tail = len(height) - 1
        max_area = 0
        while head < tail:
            area = (tail - head) * min(height[head], height[tail])
            max_area = max(max_area, area)
            if height[head] > height[tail]:
                tail -= 1
            else:
                head += 1
        return max_area


a = [1, 8, 6, 2, 5, 4, 8, 3, 7]
s = Solution()
max = s.maxArea(a)
print(max)
