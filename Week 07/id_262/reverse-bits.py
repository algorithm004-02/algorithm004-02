class Solution:
    def reverseBits(self, n):
        res, mask = 0, 1

        for i in range(32):
            if n & mask:
                res |= 1 << (31 - i)
            mask <<= 1
        return res
