# [200]岛屿数量
#
#给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
#
# 示例 1: 
#
# 输入:
#11110
#11010
#11000
#00000
#
#输出: 1
# 
#
# 示例 2: 
#
# 输入:
#11000
#11000
#00100
#00011
#
#输出: 3
# 
# Related Topics 深度优先搜索 广度优先搜索 并查集


class Solution:
    def _init(self, grid):
        self.dir = ((-1, 0), (0, 1), (1, 0), (0, -1))
        row, col = len(grid), len(grid[0])
        self.count = 0
        self.p = [0] * (row * col)
        for i in range(row):
            for j in range(col):
                if grid[i][j] == '1':
                    self.p[i * col + j] = i * col + j
                    self.count += 1

    def _root(self, i):
        while self.p[i] != i:
            self.p[i] = self.p[self.p[i]]
            i = self.p[i]
        return i

    def _union(self, i, j):
        pi = self._root(i)
        pj = self._root(j)
        if pi != pj:
            self.p[pi] = pj
            self.count -= 1

    def numIslands(self, grid) -> int:
        if not grid or not grid[0]:
            return 0

        self._init(grid)
        row, col = len(grid), len(grid[0])

        for i in range(row):
            for j in range(col):
                if grid[i][j] == '1':
                    grid[i][j] = '0'
                    for dx, dy in self.dir:
                        nx, ny = i + dx, j + dy
                        if 0 <= nx < row and 0 <= ny < col and grid[nx][ny] == '1':
                            self._union(i * col + j, nx * col + ny)

        return self.count

