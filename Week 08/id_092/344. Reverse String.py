#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
@Time : 2019/12/5 上午10:43
@Author : Catherinexxx
@Site : 
@File : 344. Reverse String.py
@Software: PyCharm
"""
class Solution(object):
    def reverseString(self, s):
        """
        :type s: List[str]
        :rtype: None Do not return anything, modify s in-place instead.
        """
        i, j = 0, len(s)-1
        while i<j:
            s[i], s[j] = s[j], s[i]
            i += 1
            j -= 1

class Solution(object):
    def reverseString(self, s):
        s[:] = s[::-1]