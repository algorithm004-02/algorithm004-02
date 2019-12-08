# [37]解数独
#
#编写一个程序，通过已填充的空格来解决数独问题。
#
# 一个数独的解法需遵循如下规则： 
#
# 
# 数字 1-9 在每一行只能出现一次。 
# 数字 1-9 在每一列只能出现一次。 
# 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。 
# 
#
# 空白格用 '.' 表示。 
#
# 
#
# 一个数独。 
#
# 
#
# 答案被标成红色。 
#
# Note: 
#
# 
# 给定的数独序列只包含数字 1-9 和字符 '.' 。 
# 你可以假设给定的数独只有唯一解。 
# 给定数独永远是 9x9 形式的。 
# 
# Related Topics 哈希表 回溯算法


class Solution:
    def solveSudoku(self, board) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        rows = [set(range(1, 10)) for _ in range(9)]
        cols = [set(range(1, 10)) for _ in range(9)]
        blocks = [set(range(1, 10)) for _ in range(9)]

        empty = []
        for i in range(9):
            for j in range(9):
                if board[i][j] != '.':
                    c = int(board[i][j])
                    rows[i].remove(c)
                    cols[j].remove(c)
                    blocks[(i // 3) * 3 + (j // 3)].remove(c)
                else:
                    empty.append((i, j))

        def solve(n=0):

            if (n == len(empty)):
                return True

            i, j = empty[n]

            b = (i // 3) * 3 + (j // 3)
            for c in rows[i] & cols[j] & blocks[b]:
                rows[i].remove(c)
                cols[j].remove(c)
                blocks[b].remove(c)
                board[i][j] = str(c)
                if solve(n + 1):
                    return True
                rows[i].add(c)
                cols[j].add(c)
                blocks[b].add(c)

            return False

        solve(0)
