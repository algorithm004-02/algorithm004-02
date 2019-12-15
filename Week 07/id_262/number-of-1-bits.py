class Solution:
    def hammingWeight(self, n: int) -> int:
        res = 0
        while n:
            res += (n & 1)
            n >>= 1
        return res
