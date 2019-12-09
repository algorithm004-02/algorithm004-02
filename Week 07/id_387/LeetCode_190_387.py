# https://leetcode.com/problems/reverse-bits/
# 190. Reverse Bits
class Solution:
  # @param n, an integer
  # @return an integer
  def reverseBits(self, n):
    res = 0
    for i in range(32):
      if (n >> i) & 1: # 获取 n 的第 i 位值 (0 或者 1)
        res |= 1 << (31 - i) # 将第 31 - i 位置为 1
    return res