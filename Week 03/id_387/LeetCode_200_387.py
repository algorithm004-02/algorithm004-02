# 200. Number of Islands
# https://leetcode.com/problems/number-of-islands/
# approach 1: dfs
class Solution:
  def numIslands(self, grid: List[List[str]]) -> int:
    if not grid: return 0
        
    res, rows, cols = 0, len(grid), len(grid[0])
    
    for i in range(rows):
      for j in range(cols):
        if grid[i][j] == "1":
          self._dfs(grid, i, j, rows, cols)
          res += 1
    return res

  def _dfs(self, grid, idx, jdx, rows, cols):
    if idx < 0 or jdx < 0 or idx >= rows or jdx >=cols or grid[idx][jdx] != "1":
      return
    
    grid[idx][jdx] = "0"
    
    self._dfs(grid, idx + 1, jdx, rows, cols)
    self._dfs(grid, idx - 1, jdx, rows, cols)
    self._dfs(grid, idx, jdx + 1, rows, cols)
    self._dfs(grid, idx, jdx - 1, rows, cols)

# approach 2: dfs
class Solution:
  def numIslands(self, grid: List[List[str]]) -> int:
    if not grid: return 0
    
    res = 0
    
    for i in range(len(grid)):
      for j in range(len(grid[0])):
        if grid[i][j] == "1":
          res += 1
          self._dfs(grid, i, j)
          
    return res

  def _dfs(self, grid, i, j):
    grid[i][j] = "0"
    
    if i + 1 <  len(grid):
      if grid[i + 1][j] == '1':        
        self._dfs(grid, i + 1, j)
        
    if i != 0:
      if grid[i - 1][j] == '1':
        self._dfs(grid, i - 1 , j)
        
    if j != 0:
      if grid[i][j - 1] == '1':
        self._dfs(grid, i , j - 1)
        
    if j + 1 < len(grid[0]):
      if grid[i][j + 1] == '1':
        self._dfs(grid, i , j + 1)  
    
    return