#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
@Time : 2019/11/15 下午3:59
@Author : Catherinexxx
@Site : 
@File : 91. Decode Ways.py
@Software: PyCharm
"""
# DP
# n = len(s)
# count[n] = count[n-1] + count[n-2]  int(s[(n-2):n])<=26
# s=123323
# c0 = 1
# c1 =
# class Solution:
#     def numDecodings(self, s: str) -> int:
#         if s == '0':
#             return 0
#         n = len(s)
#         # 最前面增加一个辅助
#         if  0<int(s[:2])<=26 and int(s[:1])!=0:
#             count = [1, 1] + [0] * (n-1)
#         elif (int(s[:2])==0 or int(s[:2])>26) and int(s[:1])!=0:
#             count = [0, 1] + [0] * (n-1)
#         else:
#             return 0

#         for i in range(2, n+1):
#             if 0<int(s[(i-2):i])<=26 and int(s[(i-1):i])!=0:
#                 count[i] = count[i-1] + count[i-2]
#             elif (int(s[(i-2):i])==0 or int(s[(i-2):i])>26) and int(s[(i-1):i])==0:
#                 return 0
#             else:
#                 count[i] = count[i-1]

#         return count[-1]

class Solution:
    def numDecodings(self, s: str) -> int:
        pp, p = 1, int(s[0] != '0')
        for i in range(1, len(s)):
            pp, p = p, pp * (9 < int(s[i-1:i+1]) <= 26) + p * (int(s[i]) > 0)
        return p

