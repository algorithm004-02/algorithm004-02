class Solution:
    def reverseBits(self, n: int) -> int:
        res = 0
        count = 32
        
        while count:
            res <<= 1
            # 取出 n 的最低位数加到 res 中
            res += n&1
            n >>= 1
            count -= 1
            
        return int(bin(res), 2)