# [52]N皇后 II
#
# n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
#
# 
#
# 上图为 8 皇后问题的一种解法。 
#
# 给定一个整数 n，返回 n 皇后不同的解决方案的数量。 
#
# 示例: 
#
# 输入: 4
#输出: 2
#解释: 4 皇后问题存在如下两个不同的解法。
#[
# [".Q..",  // 解法 1
#  "...Q",
#  "Q...",
#  "..Q."],
#
# ["..Q.",  // 解法 2
#  "Q...",
#  "...Q",
#  ".Q.."]
#]
# 
# Related Topics 回溯算法


class Solution:
    def totalNQueens(self, n: int) -> int:
        return self.solve(n, 0, 0, 0, 0) if n > 0 else 0

    def solve(self, n: int, row: int, col: int, left: int, right: int):
        if row == n:
            return 1

        count = 0
        empty = (~(col | left | right)) & ((1 << n) - 1)
        while empty:
            p = empty & -empty
            count += self.solve(n, row + 1, col | p, (left | p) << 1, (right | p) >> 1)
            empty = empty & (empty - 1)

        return count
