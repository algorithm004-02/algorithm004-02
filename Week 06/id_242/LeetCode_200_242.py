#
# @lc app=leetcode id=200 lang=python3
#
# [200] Number of Islands
#

# @lc code=start
class Solution:

    class UnionFind:
        def __init__(self, n):
            self.parent = [i for i in range(n)]
            self.count = n

        def union(self, i, j):
            p1 = self.find(i)
            p2 = self.find(j)
            if p1 != p2:
                self.parent[p1] = p2
                self.count -= 1
        
        def find(self, i):
            root = i
            while self.parent[root] != root:
                root = self.parent[root]
            while self.parent[i] != i:
                x = i
                i = self.parent[i]
                self.parent[x] = root
            return root
        
        def get_count(self):
            return self.count
    
    def numIslands(self, grid: List[List[str]]) -> int:

        if not grid or not grid[0]:
            return 0
        nr = len(grid)
        nc = len(grid[0])
        #count = 0
        # DFS
        # for i in range(nr):
        #     for j in range(nc):
        #         if grid[i][j] == '1':
        #             self.dfs(grid, i, j)
        #             count += 1

        # BFS
        # directions = [(-1, 0), (0, 1), (1, 0), (0, -1)]
        # marked = [[False] * nc for _ in range(nr)]
        # for i in range(nr):
        #     for j in range(nc):
        #         if grid[i][j] == '1' and not marked[i][j]:
        #             queue = []
        #             queue.append((i, j))
        #             marked[i][j] = True
        #             while queue:
        #                 x, y = queue.pop()
        #                 for d in directions:
        #                     new_x, new_y = x + d[0], y + d[1]
        #                     if 0 <= new_x < nr and 0 <= new_y < nc and grid[new_x][new_y] == '1' and not marked[new_x][new_y]:
        #                         queue.append((new_x, new_y))
        #                         marked[new_x][new_y] = True
        #             count += 1

        # DJ Set
        uf = self.UnionFind(nr * nc)
        t = 0
        for i in range(nr):
            for j in range(nc):
                if grid[i][j] == '0':
                    t += 1
                else:
                    if 0 <= (i+1) < nr and grid[i+1][j] == '1':
                        uf.union(i * nc + j, (i+1) * nc + j)
                    if 0 <= (j+1) < nc and grid[i][j+1] == '1':
                        uf.union(i * nc + j, i * nc + j + 1)
        return uf.get_count() - t
    
    # def dfs(self, grid: List[List[str]], r: int, c: int):
    #     nr = len(grid)
    #     nc = len(grid[0])
    #     if r < 0 or r >= nr or c < 0 or c >= nc or grid[r][c] == '0':
    #         return
    #     grid[r][c] = '0'
    #     self.dfs(grid, r-1, c)
    #     self.dfs(grid, r+1, c)
    #     self.dfs(grid, r, c-1)
    #     self.dfs(grid, r, c+1)
        
# @lc code=end

