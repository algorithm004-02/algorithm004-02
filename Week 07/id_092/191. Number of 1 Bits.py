#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
@Time : 2019/11/26 上午9:39
@Author : Catherinexxx
@Site : 
@File : 191. Number of 1 Bits.py
@Software: PyCharm
"""
# 调用库函数
class Solution(object):
    def hammingWeight(self, n):
        """
        :type n: int
        :rtype: int
        """
        return bin(n).count('1')

class Solution(object):
    def hammingWeight(self, n):
        """
        :type n: int
        :rtype: int
        """
        n = bin(n)
        count = 0
        for c in n:
            if c == "1":
                count += 1
        return count

class Solution(object):
    def hammingWeight(self, n):
        """
        :type n: int
        :rtype: int
        """
        count = 0
        while n:
            res = n % 2
            if res == 1:
                count += 1
            n //= 2
        return count

class Solution(object):
    def hammingWeight(self, n):
        """
        :type n: int
        :rtype: int
        """
        count = 0
        while n!=0:
            n &= (n-1)  # 消除最后一位1
            count += 1

        return count




