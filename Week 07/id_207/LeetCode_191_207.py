#lang=python3
# [191] 位1的个数
#

class Solution:
    def hammingWeight(self, n: int) -> int:
        # 1. use python functions
        # return bin(n).count('1')
        # 2. for loop
        # n = bin(n)
        # count = 0
        # for c in n:
        #     if c == '1':
        #         count += 1
        # return count

        count = 0
        while n:
            n &= n - 1
            count += 1
        return count