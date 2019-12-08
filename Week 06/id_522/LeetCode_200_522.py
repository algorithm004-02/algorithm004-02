
#最好成绩164ms

#并差集，在别人的代码上优化的，，感谢原作者。
#from typing import List
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:

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

            #def is_connected(self, p, q):return self.find(p) == self.find(q)--------------

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

        row = len(grid)
        # 特判
        if row == 0:return 0
        col = len(grid[0])

        def get_index(y, x):return y*col+x

        # 注意：我们不用像 DFS 和 BFS 一样，4 个方向都要尝试，只要看一看右边和下面就可以了
        #directions = [(1, 0), (0, 1)]
        # 多开一个空间，把水域 "0" 都归到这个虚拟的老大上
        #dummy_node = row * col
        # 多开的一个空间就是那个虚拟的空间
        ttt=0
        uf = UnionFind(row * col)
        for i in range(row):
            for j in range(col):
                # 如果是水域，都连到那个虚拟的空间去
                if grid[i][j] == '0': #记录水的数量
                    ttt+=1
                    #uf.union(get_index(i, j), dummy_node)  优化---------------
                else : #grid[i][j] == '1'
                    # 向下向右如果都是陆地，即 "1"，就要合并一下
                    #for direction in directions:
                    #new_x = i + 1
                    #new_y = j
                    if i+1 < row  and grid[i+1][j] == '1': #and new_y < col  is true 优化---------------
                        uf.union(get_index(i, j), get_index(i+1, j))
                    #x2=i
                    #y2=j+1
                    if  j+1 < col and grid[i][j+1] == '1': #优化---------------
                        uf.union(get_index(i, j), get_index(i, j+1))

        return uf.get_count()-ttt #优化-------------

'''
from typing import List


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:

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

            def is_connected(self, p, q):
                return self.find(p) == self.find(q)

            def union(self, p, q):
                p_root = self.find(p)
                q_root = self.find(q)
                if p_root == q_root:
                    return

                if self.rank[p_root] > self.rank[q_root]:
                    self.parent[q_root] = p_root
                elif self.rank[p_root] < self.rank[q_root]:
                    self.parent[p_root] = q_root
                else:
                    self.parent[q_root] = p_root
                    self.rank[p_root] += 1

                self.count -= 1

        row = len(grid)
        # 特判
        if row == 0:
            return 0
        col = len(grid[0])

        def get_index(x, y):
            return x * col + y

        # 注意：我们不用像 DFS 和 BFS 一样，4 个方向都要尝试，只要看一看右边和下面就可以了
        directions = [(1, 0), (0, 1)]
        # 多开一个空间，把水域 "0" 都归到这个虚拟的老大上
        dummy_node = row * col

        # 多开的一个空间就是那个虚拟的空间
        uf = UnionFind(dummy_node + 1)
        for i in range(row):
            for j in range(col):
                # 如果是水域，都连到那个虚拟的空间去
                if grid[i][j] == '0':
                    uf.union(get_index(i, j), dummy_node)
                if grid[i][j] == '1':
                    # 向下向右如果都是陆地，即 "1"，就要合并一下
                    for direction in directions:
                        new_x = i + direction[0]
                        new_y = j + direction[1]
                        if new_x < row and new_y < col and grid[new_x][new_y] == '1':
                            uf.union(get_index(i, j), get_index(new_x, new_y))
        # 不要忘记把那个虚拟结点减掉
        return uf.get_count() - 1


if __name__ == '__main__':
    grid = [['1', '1', '1', '1', '0'],
            ['1', '1', '0', '1', '0'],
            ['1', '1', '0', '0', '0'],
            ['0', '0', '0', '0', '0']]
    solution = Solution()
    result = solution.numIslands(grid)
    print(result)

作者：liweiwei1419
链接：https://leetcode-cn.com/problems/number-of-islands/solution/dfs-bfs-bing-cha-ji-python-dai-ma-java-dai-ma-by-l/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

'''



#dfs   164ms

'''
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:

        m = len(grid)
        # 特判
        if m == 0:  return 0

        n = len(grid[0])
        marked = [[False for _ in range(n)] for _w in range(m)]
        count = 0
        dx=[0,1,0,-1,0]
        dy=[1,0,-1,0]

        def dfs(x,y):
            marked[y][x]=True

            for xia in (0,1,2,3):
                xx=x+dx[xia]
               # yy=y+dy[xia]
                yy=y+dx[xia+1]
                if  -1<xx <n and -1<yy<m and not  marked[yy][xx] and grid[yy][xx]=="1":
                    dfs(xx,yy)

        for y in range(m):
            for x in range(n):

                if not marked[y][x] and grid[y][x]=="1":
                    count+=1

                    dfs(x,y)
        return count





#bfs =================bfs===================bfs====================bfs

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:

        yy = len(grid)
        # 特判
        if yy == 0:  return 0

        xx = len(grid[0])
        marked = [[False for _ in range(xx)] for _w in range(yy)]
        count = 0
        q=[]
        def bfs(y,x):
            #pass
            q.append((y,x))
            while q:
                ll=len(q)
                for i in range(ll):
                    cury,curx =q.pop(0)
                    marked[cury][curx]=True

                    t0y,t0x=cury,curx+1
                    if  -1<t0y <yy and -1<t0x<xx and not  marked[t0y][t0x] and grid[t0y][t0x]=="1":
                        marked[t0y][t0x]=True
                        q.append((t0y,t0x))

                    t1y,t1x=cury+1,curx
                    if  -1<t1y <yy and -1<t1x<xx and not  marked[t1y][t1x] and grid[t1y][t1x]=="1":
                        marked[t1y][t1x]=True
                        q.append((t1y,t1x))

                    t2y,t2x=cury-1,curx
                    if  -1<t2y <yy and -1<t2x<xx and not  marked[t2y][t2x] and grid[t2y][t2x]=="1":
                        marked[t2y][t2x]=True
                        q.append((t2y,t2x))

                    t3y,t3x=cury,curx-1
                    if  -1<t3y <yy and -1<t3x<xx and not  marked[t3y][t3x] and grid[t3y][t3x]=="1":
                        marked[t3y][t3x]=True
                        q.append((t3y,t3x))

        for y in range(yy):
            for x in range(xx):

                if not marked[y][x] and grid[y][x]=="1":
                    count+=1
                    bfs(y,x)
        return count


改进   172 ms
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:

        yy = len(grid)
        # 特判
        if yy == 0:  return 0

        xx = len(grid[0])
        marked = [[False for _ in range(xx)] for _w in range(yy)]
        count = 0
        q=[]
        def dodo(t0y,t0x):
            if  -1<t0y <yy and -1<t0x<xx and not  marked[t0y][t0x] and grid[t0y][t0x]=="1":
                marked[t0y][t0x]=True
                q.append((t0y,t0x))

        def bfs(y,x):
            #pass
            q.append((y,x))
            while q:
                ll=len(q)
                for i in range(ll):
                    cury,curx =q.pop(0)
                    marked[cury][curx]=True

                    t0y,t0x=cury,curx+1
                    dodo(t0y,t0x)

                    t1y,t1x=cury+1,curx
                    dodo(t1y,t1x)
                    #if  -1<t1y <yy and -1<t1x<xx and not  marked[t1y][t1x] and grid[t1y][t1x]=="1":  改进点
                        #marked[t1y][t1x]=True
                        #q.append((t1y,t1x))

                    t2y,t2x=cury-1,curx
                    dodo(t2y,t2x)

                    t3y,t3x=cury,curx-1
                    dodo(t3y,t3x)

        for y in range(yy):
            for x in range(xx):
                if not marked[y][x] and grid[y][x]=="1":
                    count+=1
                    bfs(y,x)
        return count
        
        
'''
'''
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        yy = len(grid)
        # 特判
        if yy == 0:  return 0
        xx = len(grid[0])
        marked = [[False for _ in range(xx)] for _w in range(yy)]
        count = 0
        q=[]
        def dodo(t0y,t0x):
            if  -1<t0y <yy and -1<t0x<xx and not marked[t0y][t0x] and grid[t0y][t0x]=="1":
                marked[t0y][t0x]=True
                q.append((t0y,t0x))

        def bfs(y,x):
            q.append((y,x))
            while q:
                ll=len(q)
                for i in range(ll):
                    cury,curx =q.pop(0)
                    marked[cury][curx]=True
                    # 东南西北
                    dodo(cury,curx+1)
                    dodo(cury+1,curx)
                    dodo(cury-1,curx)
                    dodo(cury,curx-1)
        for y in range(yy):
            for x in range(xx):
                if not marked[y][x] and grid[y][x]=="1":
                    count+=1
                    bfs(y,x)
        return count
'''
