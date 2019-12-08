# https://leetcode.com/problems/sudoku-solver
# 37. Sudoku Solver
# approach 1:
class Solution:
  def solveSudoku(self, board: List[List[str]]) -> None:
    """
    Do not return anything, modify board in-place instead.
    """
    if not board or len(board[0]) == 0: return
    if self.slove(board):
      return board
    
  def slove(self, board):
    for i in range(len(board)):
      for j in range(len(board[0])):
        if board[i][j] == ".":
          for c in range(1, 10):
            ch = str(c)

            if self.isValid(board, i, j, ch):
              board[i][j] = ch
              
              if self.slove(board): return True
              board[i][j] = "."

          return False
    return True
  
  def isValid(self, board, row, col, ch):
    for i in range(len(board)):
      if board[i][col] != "." and board[i][col] == ch: return False 
      if board[row][i] != "." and board[row][i] == ch: return False
      if board[3 * (row // 3) + i // 3][3 * (col // 3) + i % 3] != "." and board[3 * (row // 3) + i // 3][3 * (col // 3) + i % 3] == ch: return False
    return True

# approach 2:
class Solution:
  def solveSudoku(self, board: List[List[str]]) -> None:
    """
    Do not return anything, modify board in-place instead.
    """
    if not board or len(board[0]) == 0: return

    row = [set(range(1, 10)) for _ in range(9)]
    col = [set(range(1, 10)) for _ in range(9)]
    block = [set(range(1, 10)) for _ in range(9)]

    empty = []
    for i in range(len(board)):
      for j in range(len(board[0])):
        if board[i][j] != ".":
          val = int(board[i][j])
          row[i].remove(val)
          col[j].remove(val)
          block[(i // 3) * 3 + j // 3].remove(val)
        else:
          empty.append((i, j))

    if self.slove(board, empty, row, col, block):
      return board

  def slove(self, board, empty, row, col, block, iter = 0):
    if iter == len(empty): return True
    i, j = empty[iter]
    k = 3 * (i // 3) + j // 3

    for val in row[i] & col[j] & block[k]:
      row[i].remove(val)
      col[j].remove(val)
      block[k].remove(val)
      board[i][j] = str(val)

      if self.slove(board, empty, row, col, block, iter + 1):
        return True
      row[i].add(val)
      col[j].add(val)
      block[k].add(val)
    return False