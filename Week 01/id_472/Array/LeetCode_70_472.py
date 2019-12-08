#!/usr/bin/python
# -*- coding: utf-8 -*-
# @Time    : 2019/11/8
# @Author  : xujun
"""
爬楼梯
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
"""


class Solution:
    def climbStairs(self, n: int) -> int:
        f1 = 1
        f2 = 2
        if n == 1:
            return f1
        if n == 2:
            return f2
        for i in range(3, n+1):
            f3 = f1 + f2
            f1, f2 = f2, f3
        return f3



s= Solution()
print(s.climbStairs(4))