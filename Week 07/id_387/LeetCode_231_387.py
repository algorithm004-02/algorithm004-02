# https://leetcode.com/problems/power-of-two/
# 231. Power of Two
class Solution(object):
  def isPowerOfTwo(self, n):
    """
    :type n: int
    :rtype: bool
    """
    return n != 0 and n & (n - 1) == 0