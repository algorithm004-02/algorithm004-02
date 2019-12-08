#!/usr/bin/python
# -*- coding: utf-8 -*-
# @Time    : 2019/12/1
# @Author  : xujun
class Solution:
    def isPowerOfTwo(self, n: int) -> bool:
        return n > 0 and n & (n - 1) == 0
