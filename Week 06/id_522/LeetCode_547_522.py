
#执行用时 :212 ms, 在所有 python3 提交中击败了100.00%的用户

class Solution:
    def findCircleNum(self, M):
        m=len(M)
        class He:
            def __init__(self,n):
                self.p=[c for c in range(n)]
                self.k=[1 for _ in range(n)]
                self.n=n
            def f(self,z):
                while z !=self.p[z]:
                    z=self.p[self.p[z]]  #这里一次走两步
                return z
            def _he(self,g,h):
                g=self.f(g)
                h=self.f(h)
                if g==h:return
                if self.k[g]>self.k[h]:
                    self.p[h]=self.p[g]
                    self.k[g]+=1
                else:
                    self.p[g]=self.p[h]
                    self.k[h]+=1
                self.n-=1
        j=He(m)
        for y in range(m):
            for x in range(y+1,m):#对角线上 ，这里是优化，不计算对角线，y改写为y+1
                #if y==x:continue
                if M[y][x]==1:
                    j._he(y,x)
        return j.n
#函数f ，father 的意思，找爸爸。
#self.k  rank 简写了。


'''
class Solution:
    def findCircleNum(self, M):
        m=len(M)
        #合并 ，并差集
        class He:
            def __init__(self,n):
                self.p=[c for c in range(n)]
                self.rank=[1 for _ in range(n)]
                self.shu=n
            def _ma(self,z):
                while z !=self.p[z]:z=self.p[z]
                return z
            def _he(self,g,h):
                fg=self._ma(g)
                fh=self._ma(h)
                if fg==fh:return
                if self.rank[fg]>self.rank[fh]:
                    self.p[fh]=self.p[fg]
                    self.rank[fg]+=1
                else:
                    self.p[fg]=self.p[fh]
                    self.rank[fh]+=1
                self.shu-=1
        ji=He(m)
        for y in range(m):
            for x in range(y,m):#对角线以上
                if M[y][x]==1:ji._he(y,x)
        return ji.shu
'''

#看懂了下面的
'''
class Solution:
    def findCircleNum(self, M: List[List[int]]) -> int:
        n = len(M)
        p = {i: {i} for i in range(n)}  #并查集初始化
        ans = n
        for i in range(n):
            for j in range(i, n):       #遍历邻接矩阵
                if M[i][j] == 1 and p[i] is not p[j]:
                    p[i] |= p[j]        #集合合并
                    for k in p[j]:      #改变被合并的集合内元素指向
                        p[k] = p[i]
                    ans -= 1            #减少朋友圈
        return ans

作者：tuotuoli
链接：https://leetcode-cn.com/problems/friend-circles/solution/ji-he-shi-xian-bing-cha-ji-by-tuotuoli/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

执行用时 :220 ms, 在所有 python3 提交中击败了99.66%的用户   DFS  DFS DFS DFS DFS
class Solution:
    def findCircleNum(self, M):
        m=len(M)
        seta=set()
        ans=0
        def dfs(n):
            for x in range(m):      # if n is wrong,it must be m
                if M[n][x] and x not in seta:
                    seta.add(x)
                    dfs(x)
        for y in range(m):
            if y not in seta:
                ans+=1
                dfs(y)
        return ans



#BFS BFS  ------------------BFS 执行用时 :228 ms, 在所有 python3 提交中击败了97.65%的用户
class Solution:
    def findCircleNum(self, M):
        m=len(M)
        ans=0
        que=[]
        visited=set()
        
        def bfs(n):
            que.append(n)
            while que:
                cur=que.pop(0)
                for j in range(m):
                   # if M[cur][j] and j not in visited:  由于互为朋友存在，所以，这里两种写法都行。
                    if M[j][cur] and j not in visited:
                        visited.add(j)
                        que.append(j)

        for i in range(m):
            if i not in visited:
                bfs(i)
                ans+=1

        return ans

2019-11-20
'''
