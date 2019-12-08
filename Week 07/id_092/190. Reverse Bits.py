#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
@Time : 2019/11/26 上午9:51
@Author : Catherinexxx
@Site : 
@File : 190. Reverse Bits.py
@Software: PyCharm
"""
# int-->str-->reverse-->int
class Solution:
    # @param n, an integer
    # @return an integer
    def reverseBits(self, n):
        oribin='{0:032b}'.format(n)
        reversebin=oribin[::-1]
        return int(reversebin,2)


class Solution:
    def reverseBits(self, n):
        res = 0
        for _ in range(32):
            res = (res << 1) + (n & 1)
            n >>= 1
        return res