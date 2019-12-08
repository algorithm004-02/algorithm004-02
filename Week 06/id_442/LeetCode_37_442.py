# https://leetcode-cn.com/problems/sudoku-solver/

class Solution:
    def solveSudoku(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if not board or not board[0]:
            return
        # 遍历网格
        for i in range(len(board)):
            for j in range(len(board[0])):
                # 只有空位才尝试填入数字
                if board[i][j] == '.':
                    # 尝试填入1-9
                    for num in range(1, 10):
                        s = str(num)
                        # 没有冲突 确定填入
                        if self.valid(board, i, j, s):
                            board[i][j] = s
                            # 已得到最终解
                            if self.solveSudoku(board):
                                return True
                            # 否则恢复此位置 尝试其他位置
                            board[i][j] = '.'
                    return False
        return True

    def valid(self, board: List[List[str]], row: int, col: int, s: str) -> bool:
        for i in range(0, 9):
            # 行是否冲突
            if board[i][col] != '.' and board[i][col] == s:
                return False
            # 列是否冲突
            if board[row][i] != '.' and board[row][i] == s:
                return False
            # 3*3子数独是否冲突
            x, y = 3 * (row // 3) + i // 3, 3 * (col // 3) + i % 3
            if board[x][y] != '.' and board[x][y] == s:
                return False
        return True


# 更简洁的实现
class Solution:
    def solveSudoku(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        # 初始化 行、列、3*3子数独 每个位置都是一个0-9的集合
        rows = [set(range(1, 10)) for _ in range(9)]
        cols = [set(range(1, 10)) for _ in range(9)]
        boxes = [set(range(1, 10)) for _ in range(9)]

        # 扫描整个棋盘 找到可填的空位
        # 并在上述空间中剔除棋盘已有的数字
        # 剩下的就是还可以使用的数字
        empty = []
        for i in range(len(board)):
            for j in range(len(board[0])):
                b = (i // 3) * 3 + j // 3
                if board[i][j] != '.':
                    s = int(board[i][j])
                    rows[i].remove(s)
                    cols[j].remove(s)
                    boxes[b].remove(s)
                else:
                    empty.append((i, j))

        # 回溯
        def backtrace(count=0) -> bool:
            # 空位全部填完 找到最终解
            if len(empty) == count:
                return True
            i, j = empty[count]
            b = (i // 3) * 3 + j // 3
            # 行、列、子数独可用的数字集合 取交集 即不冲突可填入的数字
            # 这个决策非常巧妙 不用再写循环校验填入的数字是否冲突
            for num in rows[i] & cols[j] & boxes[b]:
                rows[i].remove(num)
                cols[j].remove(num)
                boxes[b].remove(num)
                # 尝试在此位置填入数字
                board[i][j] = str(num)
                # 递归 继续填充下一个位置 直到找到最终解
                if backtrace(count+1):
                    return True
                # 如果此次决策不能找到最终解 恢复之前的状态 继续尝试
                rows[i].add(num)
                cols[j].add(num)
                boxes[b].add(num)
            return False

        # 入口
        backtrace()

