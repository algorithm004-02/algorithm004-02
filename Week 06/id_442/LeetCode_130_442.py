# https://leetcode-cn.com/problems/surrounded-regions/

class Solution:
    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if not board:
            return
        m, n = len(board), len(board[0])
        uf = UnionFind(m * n + 1)
        for i in range(m):
            for j in range(n):
                if board[i][j] == 'O':
                    # 最外层是O 连接在一块
                    if i == 0 or j == 0 or i == m - 1 or j == n - 1:
                        uf.union(i * n + j, m * n)
                    else:
                        # 相邻的四联通是O 连在一块
                        for di, dj in ((-1, 0), (1, 0), (0, 1), (0, -1)):
                            x, y = i + di, j + dj
                            if x < m and y < n and board[x][y] == 'O':
                                uf.union(i * n + j, x * n + y)
        for i in range(m):
            for j in range(n):
                # 被包围的O设置为X
                if uf.find(i * n + j) != uf.find(m * n):
                    board[i][j] = 'X'


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
