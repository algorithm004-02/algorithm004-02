# https://leetcode-cn.com/problems/n-queens-ii/

class Solution:
    def totalNQueens(self, n: int) -> int:
        self.count = 0
        self.dfs(n, 0, 0, 0, 0)
        return self.count

    def dfs(self, n: int, row: int, cols: int, pie: int, na: int):
        if row >= n:
            self.count += 1
            return
        bits = (~(cols | pie | na)) & ((1 << n) - 1)
        while bits:
            p = bits & -bits # 取到最低位的1
            bits = bits & (bits - 1)    # 在p位置放上皇后
            self.dfs(n, row + 1, cols | p, (pie | p) << 1, (na | p) >> 1)

