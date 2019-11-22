# NOTE

周一，看了一下，视频，过了一遍，好在老师，没有让实现AVL 和 红黑树。 否则，哭了。
红黑树就是2-3树，我还没学会。

提出两个问题，关于python 的，如果有能力的同学，给予指导？？？

**1、Trie树，python 是否有标准的库，我们可以调用别人写好的库，就像，random 库，time 库，collections 库？
2、 并差集，python 是否有标准的库？或者叫做，最佳实践代码？**


周二看第二遍，准备做题。
--------------------------------时间复杂度
关于单词搜索2， 暴力搜索的时间复杂度为 N*m*m *4^k  , 其中N 是 单词的个数，
m 是搜索二维数组的边长，4 表示4个方向上搜索，k 表示最长的单词长度。

如果，使用trie 树，来解决。
首先，把单词都写入trie 树 ，需要O(N*k)
for for 两次循环 。

而后就是分析那个二维数组的遍历，虽然可以先进行一次O（m*m） 搜索，只要不在trie 中，
就记录下来，不搜了。
但最坏情况下，整个DFS 都搜索完， O(m*m *4^k)

由于无法确定 N 到底多大 ，所以，时间复杂度为 O( MAX (N*k , m*m *4^k))

这里假设k 为 7 ，那么 4^k 已经为16384 ， m假设为5  ，m*m *4^k=409600

N 大约需要超过58514 。

结论，基本用了trie 后，时间复杂度为 O(m*m *4^k)  ,对比暴力，差异明显。

-------------------------------------------双向BFS
关于双向BFS , 模板的理解，如下：

首先，就是想象在池塘的两端，同时扔进去一个大石头，波纹扩散，相遇。最短路径。

```

step =1
start={start_word}
end={end_word}
wordlist={wordlist}

while start:
    step +=1
    next_start=set()

    # 循环遍历
    for word in start:
        #建立新word
        new_word = ??
        #终止条件，找到了
        if new_word in end:return step
        else：
            #向next_start 集合中，放入需要下一步处理的数据
            #可能需要循环多次
            someword=??

            next_start.add(someword)

            wordlist.remove(someword)  #变更

    start=next_start

    if len(start)>len(end): start,end=end,start #switch 精髓所在
#没有相交
return 0

```
这几天，随着做题的数量有所上升，感觉到了，升维和降维的好处；
看了启发式搜索，老师讲的很好，就是关注估价函数怎么写，曼哈顿距离，在二维坐标中，就是速度比欧拉要快。

再有，优先级队列来了，这就是基础数据结构的力量。
最后，花花酱，告诉我们最好的是双向A* 搜索，
暂时先写BFS 吧，把 双向BFS 写好了再说吧。
这里面最牛的思想就是，对比两个集合，头和尾，哪个元素少，就让谁当头（交换位置）。
记忆心法就是侦察兵走最前面，即使被抓了，身上带的武器少，损失很小。代价很小，这里就是时间复杂度小。

明显感觉难度较大。现在是周四上午了，估计最多还能做几道题。

关于数独的，提前扫描一遍，是个不错的方法。视频看了两遍了，继续。
老师说的很对，过遍数，你会发现，理解一点一点上来了。


整体感觉，DFS ，就是傻搜，改进难；而BFS ,在理解了剪枝，双向搜索，优先级搜索后，改进了。

而启发式搜索，按照优先级出队，其实就是升维了。双向也是升维了，

所以，链表+记忆化索引=跳表
优先级队列+BFS =启发式搜索 。

算法就是老师说的，if else ，for  while ，函数调用（递归调用）。


周五上午，
# 把国际站点的，晦涩的代码，咀嚼一下
虽然可读性下降了，但是速度在800ms 左右。不如不用优先级队列的


学到的东西：

1、不改变 grid

2、记录到达此节点的上一个节点中距离起点最近的那个，并不断更新，

3、记录访问过的节点

4、记录任意节点到起点的距离，最小的那个，不断更新中

**典型的空间换时间，，思维。**

```
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
        came_from = {};juli = {(0, 0): 0};pp=[]
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
```

```
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
```

# 620ms  98.41%
```
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
        
 ```
周五下午，主要是把做过的题，看看

#这道题，准备用dfs， 和并差集来做,,结论是并差集，慢的很。
从靠边的0 开始dfs 探索。
#dfs  找到一个地方可以优化，把O(m*n) 转换为O(m+n)  168ms
```
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
        for y in range(yy):  #这里是4个边，边长和面积，时间复杂度
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
```
