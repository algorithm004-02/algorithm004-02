class Solution:
    '''
    n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
    '''
    def solveNQueens(self, n: int) -> List[List[str]]:
        res = []
        s = "." * n
        def backtrack(i, tmp,col,z_diagonal,f_diagonal):
            if i == n:
                res.append(tmp)
                return 
            for j in range(n):
                if j not in col and i + j not in  z_diagonal and i - j not in f_diagonal:
                    backtrack(i+1,tmp + [s[:j] + "Q" + s[j+1:]], col | {j}, z_diagonal |{i + j} , f_diagonal |{i - j}  ) 
            
        backtrack(0,[],set(),set(),set())    
        return res
