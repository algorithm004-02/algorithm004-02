#36 数独

class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """

        yy =[{} for _ in (0,1,2,3,4,5,6,7,8)]
        xx =[{} for x in (0,1,2,3,4,5,6,7,8)]
        box =[{} for x in (0,1,2,3,4,5,6,7,8)]


        for y in (0,1,2,3,4,5,6,7,8):
            for x in (0,1,2,3,4,5,6,7,8):

                if board[y][x]!=".":

                    num=int(board[y][x])
                    xia= (y // 3 ) * 3 + x // 3

                    yy[y][num]=yy[y].get(num,0)+1
                    xx[x][num]=xx[x].get(num,0)+1

                    box[xia][num]=box[xia].get(num,0)+1


                    if yy[y][num]>1 or xx[x][num]>1 or box[xia][num]>1:
                        return False
        return True




'''  104ms  99.37%
class Solution(object):
    def isValidSudoku(self, board):
        yy  =[{} for _ in range(9)]
        xx  =[{} for _ in range(9)]
        box =[{} for _ in range(9)]

        for y in range(9):
            for x in range(9):
                if board[y][x]!=".":
                    num=int(board[y][x])
                    xia= (y // 3 ) * 3 + x // 3

                    yy[y][num]=yy[y].get(num,0)+1
                    xx[x][num]=xx[x].get(num,0)+1
                    box[xia][num]=box[xia].get(num,0)+1
                    if yy[y][num]>1 or xx[x][num]>1 or box[xia][num]>1:
                        return False
                
        return True
'''
