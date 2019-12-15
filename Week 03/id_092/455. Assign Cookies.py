#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
@Time : 2019/10/29 下午2:08
@Author : Catherinexxx
@Site : 
@File : 455. Assign Cookies.py
@Software: PyCharm
"""

# 贪心算法
class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        g.sort()
        s.sort()
        i, j,res = 0, 0, 0
        while i < len(s) and j < len(g):
            if s[i] >= g[j]:
                res += 1
                i += 1
                j += 1
            else:
                i += 1
        return res