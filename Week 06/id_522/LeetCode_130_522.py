#这道题，准备用dfs， 和并差集来做,,结论是并差集，慢的很。

#dfs  找到一个地方可以优化，把O(m*n) 转换为O(m+n)  168ms

class Solution:
    def solve(self, b):
        if not b :return
        yy=len(b)
        xx=len(b[0])
        def dfs(b,y,x):
            #终止条件
            if y<0 or y>=yy or x<0 or x>=xx or b[y][x] in {"X" ,'#'}:return

            b[y][x] = '#'
            #dfs其他四个方向
            dfs(b,y-1,x)
            dfs(b,y+1,x)
            dfs(b,y,x-1)
            dfs(b,y,x+1)
        ss=[]
        for y in range(yy):
            ss.append((y,0))
            ss.append((y,xx-1))
        for x in range(xx):
            ss.append((0,x))
            ss.append((yy-1,x))
        for y,x in ss:
            if b[y][x]=="O":
                dfs(b,y,x)
        for y in range(yy):
            for x in range(xx):
                if b[y][x] =="#":b[y][x] ="O"
                elif b[y][x] =="O" :b[y][x] ="X"



'''
class Solution:
    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if not board :return
        yy=len(board)
        xx=len(board[0])
        def dfs(board,y,x):
            #终止条件
            if y<0 or y>=yy or x<0 or x>=xx or board[y][x] in {"X" ,'#'}:
                return
            board[y][x] = '#'
            #dfs其他四个方向
            dfs(board,y-1,x)
            dfs(board,y+1,x)
            dfs(board,y,x-1)
            dfs(board,y,x+1)
        ss=[]
        for y in range(yy):
            #x=0
            #x2=xx-1
            ss.append((y,0))
            ss.append((y,xx-1))
        for x in range(xx):
            #y2=yy-1
            ss.append((0,x))
            ss.append((yy-1,x))

        #遍历
        #for y in range(yy):
           # for x in range(xx):
               # if (x==0 or y==0 or x==xx-1 or y==yy-1 ) and board[y][x] =="O":
                  #  dfs(board,y,x)
        for y,x in ss:
            if board[y][x] =="O":dfs(board,y,x)

        #恢复
        for y in range(yy):
            for x in range(xx):
                if board[y][x] =="#":board[y][x] ="O"
                elif board[y][x] =="O" :board[y][x] ="X"
'''

''' 404ms , slowly
class Solution:
    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if not board :return
        yy=len(board)
        xx=len(board[0])
        wai=xx*yy
        def g(y, x):return y*xx+x
        
        
        class UnionFind:
            def __init__(self, n):
                self.count = n
                self.parent = [i for i in range(n)]
                self.rank = [1 for _ in range(n)]
            def get_count(self):
                return self.count

            def find(self, p):
                while p != self.parent[p]:
                    self.parent[p] = self.parent[self.parent[p]]
                    p = self.parent[p]
                return p

            def is_connected(self, p, q):return self.find(p) == self.find(q)

            def union(self, p, q):
                p_root = self.find(p)
                q_root = self.find(q)
                if p_root == q_root:return

                if self.rank[p_root] > self.rank[q_root]:
                    self.parent[q_root] = p_root
                    self.rank[p_root] += 1
                else : #self.rank[p_root] <= self.rank[q_root] 优化--------------
                    self.parent[p_root] = q_root
                    self.rank[q_root] += 1

                self.count -= 1
        uf = UnionFind(wai+1)
        for y in range(yy):
            for x in range(xx):
                if board[y][x]=="O":
                    if x==0 or x==xx-1 or y==0 or y==yy-1 :
                        uf.union(wai,g(y,x))
                    else:
                        #4 
                        if x>0 and board[y][x-1]=="O":
                            uf.union(g(y,x),g(y,x-1))
                        if x<xx-1 and board[y][x+1]=="O":
                            uf.union(g(y,x),g(y,x+1))
                        if y>0 and board[y-1][x]=="O":
                            uf.union(g(y,x),g(y-1,x))
                        if y<yy-1 and board[y+1][x]=="O": 
                            uf.union(g(y,x),g(y+1,x)) 
                            
        for y in range(yy):
            for x in range(xx):
                if  uf.is_connected(g(y,x), wai):
                    board[y][x]="O"
                    
                else:
                    board[y][x]="X"
'''

'''
class Solution:
    def solve(self, board):
        if not board :return
        yy=len(board)
        xx=len(board[0])
        wai=xx*yy
        def g(y, x):return y*xx+x
        class UnionFind:
            def __init__(self, n):self.parent = [i for i in range(n)]
        
            def find(self, p):
                while p != self.parent[p]:
                    self.parent[p] = self.parent[self.parent[p]]
                    p = self.parent[p]
                return p
            def is_connected(self, p, q):return self.find(p) == self.find(q)

            def union(self, p, q):
                pba = self.find(p)
                qba = self.find(q)
                if pba == qba:return
                self.parent[qba] = pba
   
        uf = UnionFind(wai+1)
        for y in range(yy):
            for x in range(xx):
                if board[y][x]=="O":
                    tt=g(y,x)
                    if x==0 or x==xx-1 or y==0 or y==yy-1 :
                        uf.union(wai,tt)
                    else:
                        if x>0 and board[y][x-1]=="O":
                            uf.union(tt,tt-1)
                        if x<xx-1 and board[y][x+1]=="O":
                            uf.union(tt,tt+1)
                            
                        if y>0 and board[y-1][x]=="O":
                            uf.union(tt,tt-xx)
                        if y<yy-1 and board[y+1][x]=="O": 
                            uf.union(tt,tt+xx)           
        for y in range(yy):
            for x in range(xx):
                if not uf.is_connected(g(y,x), wai):board[y][x]="X"

'''
'''  328ms  20.78%
class Solution:
    def solve(self, board):
        if not board :return
        yy,xx=len(board),len(board[0])
        wai=xx*yy
        def g(y, x):return y*xx+x
        class UnionFind:
            def __init__(self, n):self.parent = [i for i in range(n)]
        
            def find(self, p):
                while p != self.parent[p]:
                    self.parent[p] = self.parent[self.parent[p]]
                    p = self.parent[p]
                return p
            def is_connected(self, p, q):return self.find(p) == self.find(q)

            def union(self, p, q):
                pba = self.find(p)
                qba = self.find(q)
                if pba == qba:return
                self.parent[qba] = pba
   
        uf = UnionFind(wai+1)
        for y in range(yy):
            for x in range(xx):
                if board[y][x]=="O":
                    tt=g(y,x)
                    if x==0 or x==xx-1 or y==0 or y==yy-1 :uf.union(wai,tt)
                    else:
                        try:
                            if board[y][x-1]=="O":uf.union(tt,tt-1)
                        except:pass
                        try:
                            if board[y][x+1]=="O":uf.union(tt,tt+1)    
                        except:pass
                        try:
                            if board[y-1][x]=="O":uf.union(tt,tt-xx)
                        except:pass
                        try:
                            if board[y+1][x]=="O":uf.union(tt,tt+xx)  
                        except:pass                                                 
        for y in range(yy):
            for x in range(xx):
                if not uf.is_connected(g(y,x), wai):board[y][x]="X"

'''
