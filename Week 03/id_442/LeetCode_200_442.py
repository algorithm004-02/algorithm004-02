# https://leetcode-cn.com/problems/number-of-islands/submissions/

# DFS实现
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid:
            return 0

        nums = 0
        nr, nc = len(grid), len(grid[0])
        for i in range(nr):
            for j in range(nc):
                if grid[i][j] == '1':
                    nums += 1
                    self.dfs(grid, i, j)
        return nums

    def dfs(self, grid: List[List[str]], i: int, j: int):
        nr, nc = len(grid), len(grid[0])
        if i < 0 or j < 0 or i >= nr or j >= nc or grid[i][j] == '0':
            return
        grid[i][j] = '0'
        self.dfs(grid, i - 1, j)
        self.dfs(grid, i + 1, j)
        self.dfs(grid, i, j - 1)
        self.dfs(grid, i, j + 1)
