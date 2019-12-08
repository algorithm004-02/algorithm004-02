# https://leetcode.com/problems/number-of-islands/
# 200. Number of Islands
# approach: disjoint
class Solution:
  def numIslands(self, grid: List[List[str]]) -> int:
    if not grid: return 0
    
    row, col = len(grid), len(grid[0])
    p = [i for i in range(row * col)]

    for i in range(row):
      for j in range(col):
        if grid[i][j] == "1":
          if i and grid[i - 1][j] == "1":
            self._union(p, i * col + j, (i - 1) * col + j)
            
          if j and grid[i][j - 1] == "1":
            self._union(p, i * col + j, i * col + (j - 1))
          
    return len(set(self._parent(p, i) for i in range(row * col) if grid[i // col][i % col] == "1"))

  def _union(self, p, i, j):
    p1 = self._parent(p, i)
    p2 = self._parent(p, j)
    p[p2] = p1

  def _parent(self, p, i):
    root = i
    while p[root] != root:
      root = p[root]
    while p[i] != i:
      x = i; i = p[i]; p[x] = root
    return root