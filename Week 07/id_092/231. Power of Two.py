#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
@Time : 2019/11/26 上午9:49
@Author : Catherinexxx
@Site : 
@File : 231. Power of Two.py
@Software: PyCharm
"""
class Solution:
    def isPowerOfTwo(self, n: int) -> bool:
        # 二进制有且仅有一个1
        return n!=0 and n&(n-1) == 0