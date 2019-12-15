# https://leetcode.com/problems/n-queens-ii/description/
# 52. N-Queens II
class Solution(object):
  def totalNQueens(self, n):
    """
    :type n: int
    :rtype: int
    """
    if n < 1: return []
    self.result = 0
    self._dfs(n, 0, 0, 0, 0)
    return self.result
  
  def _dfs(self, n, row, col, pie, na):
    if row >= n: 
      self.result += 1
      return
    
    bits = (~(col | pie | na)) & ((1 << n) - 1)
    
    while bits:
      p = bits & -bits
      self._dfs(n, row + 1, col | p, (pie | p) << 1, (na | p) >> 1)
      bits = bits & (bits - 1)