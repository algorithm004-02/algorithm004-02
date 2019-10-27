#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
@Time : 2019/10/21 下午3:04
@Author : Catherinexxx
@Site : 
@File : 242.valid-anagram.py
@Software: PyCharm
"""

# # # 1、暴力比较sorted是否等 O(nlogn)
# class Solution:
#     def isAnagram(self, s: str, t: str) -> bool:
#         ls = sorted(s)
#         lt = sorted(t)
#         return ls == lt

# 2、hashmap  遍历s存++ 遍历t删——  O(n)
class Solution:
     def isAnagram(self, s: str, t: str) -> bool:
        hashmap = {}
        for i in range(len(s)):
            if s[i] in hashmap:
                hashmap[s[i]] += 1
            else:
                hashmap[s[i]] = 1
        for j in range(len(t)):
            if t[j] in hashmap:
                hashmap[t[j]] -= 1
            else:
                return False
        for v in hashmap.values():
            if v != 0:
                return False
        return True