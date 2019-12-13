# https://leetcode.com/problems/minimum-path-sum/
# 64. Minimum Path Sum
class Solution:
  def minPathSum(self, grid: List[List[int]]) -> int:
    row, col = len(grid), len(grid[0]) 
    dp = [0] + [sys.maxsize] * (col-1)
    for i in range(row):
        dp[0] = dp[0] + grid[i][0]
        for j in range(1, col):
            dp[j] = min(dp[j-1], dp[j]) + grid[i][j]
    return dp[-1]