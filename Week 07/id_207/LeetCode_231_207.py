# lang=python3
# [231] 2的幂

class Solution:
    def isPowerOfTwo(self, n: int) -> bool:
        return (n > 0) and (n & (n -1 ) == 0)
