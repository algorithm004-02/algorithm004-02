"""
编写一个程序，通过已填充的空格来解决数独问题。

一个数独的解法需遵循如下规则：

数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
空白格用 '.' 表示。



一个数独。



答案被标成红色。

Note:

给定的数独序列只包含数字 1-9 和字符 '.' 。
你可以假设给定的数独只有唯一解。
给定数独永远是 9x9 形式的。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sudoku-solver
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
"""
        Do not return anything, modify board in-place instead.
        """
        """
        Step 1: 准备数据，先过滤数据，建立row, col, box的set
        Step 2: 先遍历一遍Board, 把已经填过的数据过滤掉，把待填写的格子坐标保存起来
        Step 3: 遍历待填写的数据，递归处理，逐个解决，直到待填写的数据变为空
        Step 4: 此处用到了递归回溯的方法，套用模版
        """
        row = [set(range(1, 10)) for i in range(9)]
        col = [set(range(1, 10)) for i in range(9)]
        box = [set(range(1, 10)) for i in range(9)]
        
        # 预检查数独
        empty = []
        for i in range(9):
            for j in range(9):
                if board[i][j] != ".":
                    val = int(board[i][j])
                    row[i].remove(val)
                    col[j].remove(val)
                    box[(i // 3) * 3 + j // 3].remove(val)
                else:
                    empty.append((i, j))
                    
        def backtrace(iter = 0):
            if iter == len(empty):
                return True
            i, j = empty[iter]
            box_index = (i // 3) * 3 + j // 3
            for val in row[i] & col[j] & box[box_index]: #直接取row, col, box的公共部分，取验证
                row[i].remove(val)
                col[j].remove(val)
                box[box_index].remove(val)
                board[i][j] = str(val)
                if backtrace(iter + 1):
                    return True
                row[i].add(val)
                col[j].add(val)
                box[box_index].add(val)
            return False
        backtrace()