# [130]被围绕的区域
#
#给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
#
# 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。 
#
# 示例: 
#
# X X X X
#X O O X
#X X O X
#X O X X
# 
#
# 运行你的函数后，矩阵变为： 
#
# X X X X
#X X X X
#X X X X
#X O X X
# 
#
# 解释: 
#
# 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。 
# Related Topics 深度优先搜索 广度优先搜索 并查集


class Solution:

    def _init(self, grid):
        self.dir = ((-1, 0), (0, 1), (1, 0), (0, -1))
        self.row, self.col = len(grid), len(grid[0])
        self.p = [-1] * (self.row * self.col)
        self.q = [0] * len(self.p)
        for i in range(self.row):
            for j in range(self.col):
                if grid[i][j] == 'O':
                    self.p[i * self.col + j] = i * self.col + j

    def _root(self, i):
        root = i
        while self.p[root] != root:
            root = self.p[root]
        while self.p[i] != i:
            x = i
            i = self.p[i]
            self.p[x] = root
        return root

    def _union(self, x1, y1, x2, y2):
        p1 = self._root(x1 * self.col + y1)
        p2 = self._root(x2 * self.col + y2)
        if p1 != p2:
            if 0 < int(p2 / self.col) < self.row - 1 and 0 < p2 % self.col < self.col - 1:
                self.p[p2] = p1
            else:
                self.p[p1] = p2

    def solve(self, board) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if not board or not board[0]:
            return

        self._init(board)

        for i in range(self.row):
            for j in range(self.col):
                if board[i][j] == 'O':
                    self.q[i * self.col + j] = 1
                    for dx, dy in self.dir:
                        nx, ny = i + dx, j + dy
                        if 0 <= nx < self.row and self.col > ny >= 0 == self.q[nx * self.col + ny] and board[nx][ny] == 'O':
                            self._union(i, j, nx, ny)

        print(self.p)
        for i in range(self.row * self.col):
            p = self._root(i)
            if p > 0:
                x, y = int(p / self.col), p % self.col
                if 0 < x < self.row - 1 and 0 < y < self.col - 1:
                    board[int(i / self.col)][i % self.col] = 'X'
