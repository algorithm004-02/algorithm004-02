from typing import List


class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        if len(grid) == 0:
            return 0
        row = len(grid)
        col = len(grid[0])

        for i in range(row):
            for j in range(col):
                if i == j == 0:
                    continue
                elif i == 0:
                    grid[0][j] += grid[0][j - 1]
                elif j == 0:
                    grid[i][0] += grid[i - 1][0]
                else:
                    grid[i][j] = min(grid[i - 1][j] + grid[i][j], grid[i][j - 1] + grid[i][j])
        return grid[-1][-1]

