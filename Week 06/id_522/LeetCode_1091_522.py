# 把国际站点的，晦涩的代码，咀嚼一下，，
#启发式 优先级队列
#虽然可读性下降了，但是速度在800ms 左右，不好。速度比bfs 620秒，差不少。

'''
#学到的东西：
1、不改变 grid
2、记录到达此节点的上一个节点中距离起点最近的那个，并不断更新，
3、记录访问过的节点
4、记录任意节点到起点的距离，最小的那个，不断更新中

典型的空间换时间

'''
from heapq import heappush, heappop
class Solution:
    def shortestPathBinaryMatrix(self, grid):
        if grid[0][0] == 1: return -1

        def path(came_from, end):
            pa = []
            while end != (0, 0):
                end = came_from[end]
                pa.append(end)
            return len(pa)+1
        s ,v = len(grid),set()
        came_from = {}
        juli = {(0, 0): 0}
        pp=[]
        heappush(pp,(0,0,0))
        d8 = ((1, 1), (1, 0), (0, 1), (1, -1), (-1, 1), (0, -1), (-1, 0), (-1, -1))

        while pp:
            you,y,x=heappop(pp);node=(y,x)
            if node in v: continue
            if y == x == s - 1:return path(came_from, node)
            v.add(node)
            for d in d8:
                a, b = y + d[0], x + d[1]
                if -1 < a < s and -1 < b < s and grid[a][b] == 0 :
                    tt=max(abs(s - a), abs(s - b))
                    heappush(pp,(juli[node] +tt ,a,b))
                    if ((a, b) not in juli or juli[node] + 1 < juli[(a, b)]):
                        juli[(a, b)] = juli[node] + 1
                        came_from[(a, b)] = node
        return -1

'''
from heapq import heappush, heappop
class PriorityQueue:
    def __init__(self, iterable=[]):
        self.heap = []
        for value in iterable:
            heappush(self.heap, (0, value))

    def add(self, value, priority=0):
        heappush(self.heap, (priority, value))

    def pop(self):
        priority, value = heappop(self.heap)
        return value

    def __len__(self):
        return len(self.heap)

class Solution:
    def shortestPathBinaryMatrix(self, grid):
        if grid[0][0] == 1: return -1

        def reconstruct_path(came_from, end):
            """
            >>> came_from = {'b': 'a', 'c': 'a', 'd': 'c', 'e': 'd', 'f': 'd'}
            >>> reconstruct_path(came_from, 'a', 'e')
            ['a', 'c', 'd', 'e']
            """
            reverse_path = [end]
            while end != (0, 0):
                end = came_from[end]
                reverse_path.append(end)
                # print(list(reversed(reverse_path)))
            return len(reverse_path)

        s = len(grid)

        visited = set()
        came_from = dict()
        distance = {(0, 0): 0}
        pp = PriorityQueue()
        pp.add((0, 0))
        d8 = ((1, 1), (1, 0), (0, 1), (1, -1), (-1, 1), (0, -1), (-1, 0), (-1, -1))

        while pp:
            node = pp.pop()
            y, x = node[0], node[1]
            if node in visited: continue

            if y == x == s - 1:
                return reconstruct_path(came_from, node)

            visited.add(node)
            for d in d8:
                a, b = y + d[0], x + d[1]
                if -1 < a < s and -1 < b < s and grid[a][b] == 0:

                    pp.add((a, b), priority=distance[node] + max(abs(s - a), abs(s - b)))

                    if ((a, b) not in distance or distance[node] + 1 < distance[(a, b)]):
                        distance[(a, b)] = distance[node] + 1
                        came_from[(a, b)] = node
        return -1
'''

# 620ms  98.41%
'''
class Solution:
    def shortestPathBinaryMatrix(self, g):
        if g[0][0] == 1: return -1
        s = len(g)
        from collections import deque
        q = deque()
        q.append((0, 0, 1))
        g[0][0] = 1
        d8 = ((1, 1), (1, 0), (0, 1), (1, -1), (-1, 1), (0, -1), (-1, 0), (-1, -1))
        while q:
            y, x, step = q.popleft()
            if y == x == s - 1: return step
            for d in d8:
                yy, xx = y + d[0], x + d[1]
                if -1 < xx < s and -1 < yy < s and g[yy][xx] == 0:
                    g[yy][xx] = 1
                    q.append((yy, xx, step + 1))
        return -1
'''

'''                -------------------启发式搜索，优先级队列
class Solution:
    def shortestPathBinaryMatrix(self, g):
        if g[0][0]==1:return -1
        s,q=len(g),[]
        from heapq import heappush, heappop
        heappush(q,(1,0,0,0)) 
        g[0][0]=1
        t =((1,1),(1,0),(0,1),(1,-1),(-1,1),(0,-1),(-1,0),(-1,-1))
        while q :
            step,z,y,x=heappop(q)
            if y==x==s-1:return step
            for d in t:
                yy,xx=y+d[0],x+d[1]
                if -1<xx<s and -1<yy<s and g[yy][xx]==0:
                    g[yy][xx]=1
                    #p=-yy-xx
                    heappush(q,(step+1,-yy-xx,yy,xx))           
        return -1


 860ms
class Solution:
    def shortestPathBinaryMatrix(self, g):
        if g[0][0]==1:return -1
        s=len(g)
        from heapq import heappush, heappop


        def you(y,x):return s+s-y-x

        q=[]
        #           step      次优先级      坐标y,x
        #heappush(q,(1,         0,        0,0))
        heappush(q,(1,0,0,0))

        #q.append((0,0,1))
        g[0][0]=1
        d8 =((1,1),(1,0),(0,1),(1,-1),(-1,1),(0,-1),(-1,0),(-1,-1))
        while q :

            #y,x,step =q.popleft()
            step,z,y,x=heappop(q)
            print(y,x)

            if y==x==s-1:return step
            ttt=[]
            for d in d8:
                yy,xx=y+d[0],x+d[1]

                if -1<xx<s and -1<yy<s and g[yy][xx]==0:
                    g[yy][xx]=1
                    p=s+s-yy-xx
                    #q.append((yy,xx,step+1))
                    heappush(q,(step+1,pp,yy,xx))

        return -1
        
class Solution:
    def shortestPathBinaryMatrix(self, grid):
        if grid[0][0]==1:return -1
        s=len(grid)
        from collections import deque
        q=deque()
        q.append((0,0,1))
        grid[0][0]=1
        d8=((0,-1),(0,1),(-1,-1),(-1,0),(-1,1),(1,-1),(1,0),(1,1))
        while q:
            y,x,step=q.popleft()
            if x==y==s-1:return step
            for d in d8:
                yy=y+d[0]
                xx=x+d[1]
                if  -1<xx<s  and -1<yy<s and grid[yy][xx]==0:
                    grid[yy][xx]=1
                    q.append((yy,xx,step+1))

        return -1 
        '''
'''
周六晚上，突然，想用并差集，双向BFS 解决一下，1091 用了一个多小时，速度不快，800ms

我分析的时间复杂度，在O(n^2)  n是矩阵边长。
这么分析的，虽然while 那里不好分析，我认为，每次处理后，visited 最少加一，
如果不加，ss是空集，while 就停止了。
一共有 n*n 个格子，所以，时间复杂度O(8*n*n) 也就是 O(n^2)

class Solution:
    def shortestPathBinaryMatrix(self, g):
        #some special case 
        if g[0][0] == 1: return -1
        s = len(g)
        if s==1:return 1 #g=[[0]]
        if g[s-1][s-1] == 1: return -1
        #ss =start ，dd=end 
        ss,dd=set(),set()   
        ss.add((0,0))
        dd.add((s-1,s-1))
        visited=set()
        #donot change the grid 
        #g[0][0] = 1  
        #g[s-1][s-1]=1
        visited.add((0,0))
        visited.add((s-1,s-1))
        for y in range(s):
            for x in range(s):
                if g[y][x]==1:visited.add((y,x))
                
        d8=((1, 1), (1, 0), (0, 1), (1, -1), (-1, 1), (0, -1), (-1, 0), (-1, -1))
        step=2
        while ss:
            t=set()
            #层序遍历
            ll=len(ss)
            for i in range(ll):
                #集合无序，随便拿出一个
                y,x=ss.pop()
                for d in d8:
                    yy, xx = y + d[0], x + d[1]
                    #终止情况
                    if (yy,xx) in dd:return step
                    
                    if -1 < xx < s and -1 < yy < s  and (yy,xx) not in visited:
                        t.add((yy,xx)) 
                        visited.add((yy,xx))
            ss=t 
            if len(ss)>len(dd): ss,dd =dd,ss
            step+=1
        return -1

'''
