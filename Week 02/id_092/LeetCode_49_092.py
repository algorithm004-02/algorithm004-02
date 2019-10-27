#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
@Time : 2019/10/21 下午4:18
@Author : Catherinexxx
@Site : 
@File : 49.group-anagrams.py
@Software: PyCharm
"""

# 1、hashmap查找 sort ==
class Solution:
    def groupAnagrams(self, strs):
        i = 0
        hashmap = {}
        while i < len(strs):
            s = tuple(sorted(strs[i]))
            if s in hashmap:
                hashmap[s].append(strs[i])
            else:
                hashmap[s] = [strs[i]]
            i += 1
        return hashmap.values()

## collections.defaultdict(list)
# class Solution(object):
#     def groupAnagrams(self, strs):
#         ans = collections.defaultdict(list)
#         for s in strs:
#             ans[tuple(sorted(s))].append(s)
#         return ans.values()

# # 2、hashmap 个数==
# class Solution:
#     def groupAnagrams(self, strs):
#         ans = collections.defaultdict(list)
#         for s in strs:
#             count = [0] * 26
#             for c in s:
#                 count[ord(c) - ord('a')] += 1
#             ans[tuple(count)].append(s)
#         return ans.values()