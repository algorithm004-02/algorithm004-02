# 51. N-Queens
# https://leetcode.com/problems/n-queens/

class Solution:
  def solveNQueens(self, n: int) -> List[List[str]]:
    if n < 1: return []
    self.result = []
    self._dfs(n, [], [], [])
    return [["." * i + "Q" + "." * (n - i - 1) for i in res] for res in self.result]
  
  def _dfs(self, n, curr, pie, na):
    row = len(curr)
    if len(curr) == n:
      self.result.append(curr)
      return
    
    for col in range(n):
      if col not in curr and col - row not in pie and col + row not in na:
        self._dfs(n, curr + [col], pie + [col - row], na + [col + row])
        