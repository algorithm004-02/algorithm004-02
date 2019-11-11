# 74. Search a 2D Matrix
# https://leetcode.com/problems/search-a-2d-matrix/
# approach 1: binary search
class Solution:
  def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
    if not matrix or target is None: return False
    rows, cols = len(matrix), len(matrix[0])
    l, r = 0, rows * cols - 1
    while l <= r:
      m = (l + r) // 2
      nums = matrix[m // cols][m % cols]
      if nums == target:
        return True
      elif nums < target:
        l = m + 1
      else:
        r = m - 1
    return False

# approach 2: binary search
class Solution:
  def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
    if not matrix or target is None: return False
    rows, cols = len(matrix), len(matrix[0])
    r, c = rows - 1, 0
    while r >= 0 and c < cols:
      if matrix[r][c] == target:
        return True
      elif matrix[r][c] > target:
        r -= 1
      else:
        c += 1
    return False