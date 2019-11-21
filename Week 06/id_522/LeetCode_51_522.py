#难度大,,对撇捺的理解，很重要

#60ms
class Solution:
    def solveNQueens(self,n):
        r=[]
        def dfs(q,cha,he):
            y=len(q)
            if y==n: #8
                r.append(["."*i +"Q"+"."*(n-1-i) for i in q])
                return
            for x in range(n):
                if x not in q and y-x not in cha and y+x not in he:
                    dfs(q+[x],cha|{y-x},he|{y+x})
        dfs([],set(),set())
        return r



'''
class Solution:
    def solveNQueens(self,n):
        r=[]
        def dfs(q,cha,he):
            y=len(q)
            if y==n: #8
                a=["."*i +"Q"+"."*(n-1-i) for i in q]
                r.append(a)
                return
            for x in range(n):
                if x not in q and y-x not in cha and y+x not in he:
                    dfs(q+[x],cha+[y-x],he+[y+x])
        dfs([],[],[])
        return r

class Solution:
    def solveNQueens(self, n):
        res=[]
        
        def dfs(queens,cha,he):
            y=len(queens)  #y轴，就是行号
            if y==n: #8
                a=["."*i +"Q"+"."*(n-1-i) for i in queens]
                res.append(a)
                return
            
            for x in range(n):
                if x in queens or y-x in cha or y+x in he:continue
                dfs(queens+[x],cha+[y-x],he+[y+x])
            #return
        dfs([],[],[])
        return res
'''
