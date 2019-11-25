# 1、转化成岛屿（200）问题 DFS
# # 2、并查集disjoint set
# a N个人独立集合
# b 遍历好友关系 根据mij？=1合并
# c 看有多少集合
class Solution:
    def findCircleNum(self, M: List[List[int]]) -> int:
        # 初始化
        s = [i for i in range(len(M))]

        # 遍历M
        for i in range(len(M)):
            for j in range(len(M)):
                if M[i][j] == 1:
                    self.union(s, i, j)

        # 最后看剩下几个集合或者领头
        return len(set([self.parent(s, i) for i in range(len(M))]))

    def union(self, p, i, j):
        p1 = self.parent(p, i)
        p2 = self.parent(p, j)
        p[p1] = p2

    def parent(self, p, i):
        root = i
        while p[root] != root:
            root = p[root]
        while p[i] != i:  # 路径压缩 ?
            x = i;
            i = p[i];
            p[x] = root
        return root
