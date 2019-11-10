#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
@Time : 2019/10/29 下午2:15
@Author : Catherinexxx
@Site : 
@File : 122. Best Time to Buy and Sell Stock II.py
@Software: PyCharm
"""

# 贪心算法
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        res, i , j = 0, 0, 1
        while i < len(prices) and j < len(prices):
            if prices[i] < prices[j]:
                res += prices[j] - prices[i]
            i += 1
            j += 1
        return res