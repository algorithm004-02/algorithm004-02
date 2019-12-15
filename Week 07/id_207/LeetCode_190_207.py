#lang=python3
# [190] 颠倒二进制位

class Solution:
    def reverseBits(self, n: int) -> int:
        res = 0
        for i in range(32):
            # 将n的最低位放到res中
            # 将res左移，n右移
            res <<= 1
            res += n & 1
            n >>= 1
<<<<<<< HEAD
        return res
=======
        return res
    
>>>>>>> 8fe26f6a4e46679f8d1b1ee01edf8197505ca1be
