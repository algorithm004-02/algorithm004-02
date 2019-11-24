class Solution:
    """
    剪枝
    我们把board[i][j]
    用字符串：
    表示行：(i) + board[i][j]
    表示列：board[i][j] + (j)
    表示小正方形：(i) + board[i][j] + (j)
    就直接可以用一个集合搞定！
    """
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        one_set = set()
        
        for i in range(9):
            for j in range(9):
                if board[i][j].isdigit():
                    row = "(" + str(i) + ")" + board[i][j]
                    col = board[i][j] + "(" + str(j) + ")"
                    small_square = "(" + str(i//3)+ ")" + board[i][j] +  "(" + str(j//3) + ")"
                    if row in one_set or col in one_set or small_square in one_set:
                        return False
                    one_set.update([row,col,small_square])
        return True