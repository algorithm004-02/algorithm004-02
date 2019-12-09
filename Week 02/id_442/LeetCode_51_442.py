# https://leetcode-cn.com/problems/n-queens/submissions/

# 递归回溯
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        self.result = []
        self.cols = set()
        self.pie = set()
        self.na = set()
        self.dfs(n, 0, [])
        return self._generate(n)

    def dfs(self, n: int, row: int, current: List[str]):
        if row >= n:
            self.result.append(current)
            return

        for col in range(n):
            if col in self.cols or row + col in self.pie or row - col in self.na:
                continue

            self.cols.add(col)
            self.pie.add(row + col)
            self.na.add(row - col)

            self.dfs(n, row + 1, current + [col])

            self.cols.remove(col)
            self.pie.remove(row + col)
            self.na.remove(row - col)

    def _generate(self, n: int) -> List[List[str]]:
        board = []
        for item in self.result:
            for i in item:
                board.append('.' * i + 'Q' + '.' * (n - i -1))
        return [board[i: i+n] for i in range(0, len(board), n)]
