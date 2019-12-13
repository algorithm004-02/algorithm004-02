#!/usr/bin/python
# -*- coding: utf-8 -*-
# @Time    : 2019/12/1
# @Author  : xujun
class Solution:
    def hammingWeight(self, n: int) -> int:
        total = 0
        while n != 0:
            total += 1
            n = n & (n - 1)
