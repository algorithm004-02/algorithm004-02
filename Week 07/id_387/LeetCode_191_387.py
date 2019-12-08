# https://leetcode.com/problems/number-of-1-bits/
# 191. Number of 1 Bits
class Solution(object):
  def hammingWeight(self, n):
    """
    :type n: int
    :rtype: int
    """
    res = 0
    while n:
      n &= n -1
      res += 1
    return res