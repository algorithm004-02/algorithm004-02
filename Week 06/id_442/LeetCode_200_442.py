# https://leetcode-cn.com/problems/number-of-islands/

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid:
            return 0
        m, n = len(grid), len(grid[0])
        uf = UnionFind(m * n + 1)
        for i in range(m):
            for j in range(n):
                # 所有的'水'连在一起
                if grid[i][j] == '0':
                    uf.union(i * n + j, m * n)
                    continue
                # 相邻的'陆地'连在一起
                for di, dj in ((1, 0), (0, 1)):
                    x, y = di + i, dj + j
                    if x < m and y < n and grid[x][y] == '1':
                        uf.union(i * n + j, x * n + y)
        return uf.count - 1 # 减去'水'的区域

class UnionFind:

    def __init__(self, n: int):
        self.count = n
        self.parent = [i for i in range(n)]

    def union(self, i: int, j: int):
        pi = self.find(i)
        pj = self.find(j)
        if pi == pj:
            return
        self.parent[pi] = pj
        self.count -= 1

    def find(self, i: int) -> int:
        node = i
        while self.parent[node] != node:
            node = self.parent[node]
        while self.parent[i] != i:
            x = i
            i = self.parent[i]
            self.parent[x] = node
        return node
