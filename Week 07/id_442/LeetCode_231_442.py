# https://leetcode-cn.com/problems/power-of-two/

# 二进制位有且仅有1位是1 清空最低位的1后就是0
class Solution:
    def isPowerOfTwo(self, n: int) -> bool:
        return n > 0 and n & (n - 1) == 0

