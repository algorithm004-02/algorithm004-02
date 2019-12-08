#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
@Time : 2019/11/1 下午12:29
@Author : Catherinexxx
@Site : 
@File : 74. Search a 2D Matrix.py
@Software: PyCharm
"""


# # 看成一维 二分
# class Solution:
#     def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
#         if not matrix: return False
#         row = len(matrix)
#         col = len(matrix[0])
#         left = 0
#         right = row * col
#         while left < right:
#             mid = left + (right - left) // 2
#             if matrix[mid // col][mid % col] < target:
#                 left = mid + 1
#             else:
#                 right = mid
#         #print(left,right)
#         return left < row * col and matrix[left // col][left % col] == target


# 双二分
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix: return False
        row, col = len(matrix) - 1, len(matrix[0]) - 1
        # 搜行
        left, right = 0, row
        while left < right:
            mid = left + (right - left) // 2
            if matrix[mid][-1] == target:
                return True
            if matrix[mid][-1] > target:
                right = mid
            else:
                left = mid + 1

        m = set(matrix[left])
        # 搜列
        return target in m