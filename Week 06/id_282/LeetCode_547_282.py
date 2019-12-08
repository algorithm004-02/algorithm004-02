class Solution(object):
    def findCircleNum(self, M):
        """
        :type M: List[List[int]]
        :rtype: int
        """
        # 声明表示集合的树，用数组表示树，如 parent[5] == -1 表示
        # 5 是某个集合的代表，同时也是树根
        parent = [-1] * len(M)
        # 为各个集合的深度排个序
        rank = dict()
        # 只遍历左下部分
        for i in range(len(M)):
            for j in range(i):
                if M[i][j] == 1:
                    # 如果两人是朋友，就把两人放入同一个集合
                    self.union(i, j, parent, rank)
        ans = 0
        for i in parent: # 查看有多少集合，即多少个朋友圈
            if i == -1:
                ans += 1
        return ans
    
    def findRoot(self, num, parent):
        """
        :num：某个小朋友
        :parent：多个集合树
        一直找到这个小朋友所在集合的代表，即树根
        """
        while parent[num] != -1:
            num = parent[num]
        return num

    def union(self, x, y, parent, rank):
        """
        x，y 表示满足朋友关系的两小朋友
        """
        if x == y: # 表示自己和自己是朋友，这个直接返回
            return
        x = self.findRoot(x, parent) # 找到所在集合的代表，可能就是自己
        y = self.findRoot(y, parent)
        rank_x = rank[x] if x in rank else 0 # 查询该集合目前的深度
        rank_y = rank[y] if y in rank else 0
        if x == y: # 检测到 x, y 已经是在同一个集合了，直接返回
            return
        if rank_x > rank_y: # 这里是做路径压缩的，避免树太深使得 findRoot 函数耗时过多
            parent[y] = x
        elif rank_x < rank_y:
            parent[x] = y
        else:
            parent[x] = y
            rank[y] = 1