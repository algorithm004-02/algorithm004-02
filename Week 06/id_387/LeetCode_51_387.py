# https://leetcode.com/problems/n-queens
# 51. N-Queens
# approach: dfs
class Solution:
  def solveNQueens(self, n: int) -> List[List[str]]:
    if not n: return []
    self.result = []
    self._dfs(n, [], [], [])
    return [["." * i + "Q" + "." * (n - i - 1) for i in res] for res in self.result]
  
  def _dfs(self, n, cur, pie, na):
    row = len(cur)
    
    if len(cur) == n:
      self.result.append(cur)
      return 
    
    for col in range(n):
      if col not in cur and col - row not in pie and col + row not in na:
        self._dfs(n, cur + [col], pie + [col - row], na + [col + row])