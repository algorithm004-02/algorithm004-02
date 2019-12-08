# https://leetcode.com/problems/word-search-ii/
# 212. Word Search II
class Solution:
  def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
    if not board or not words or not board[0]: return []
    root = collections.defaultdict()
    self.result = set()
    
    for word in words:
      node = root
      for ch in word:
        node = node.setdefault(ch, collections.defaultdict())
      node[None] = True
    
    self.m, self.n = len(board), len(board[0])
    
    for r in range(self.m):
      for c in range(self.n):
        if board[r][c] in root:
          self._dfs(board, r, c, "", root)
    
    return list(self.result)
  
  def _dfs(self, board, row, col, curWord, curDict):
    curWord += board[row][col]
    curDict = curDict[board[row][col]]
    
    if None in curDict:
      self.result.add(curWord)
    
    tmp, board[row][col] = board[row][col], "@"
    for (i, j) in {(-1, 0), (1, 0), (0, -1), (0, 1)}:
      x, y = row + i, col + j
      if 0 <= x < self.m and 0 <= y < self.n and board[x][y] != "@" and board[x][y] in curDict:
        self._dfs(board, x, y, curWord, curDict)
    
    board[row][col] = tmp