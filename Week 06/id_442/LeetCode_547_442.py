# https://leetcode-cn.com/problems/friend-circles/

class Solution:
    def findCircleNum(self, M: List[List[int]]) -> int:
        if not M:
            return 0
        n = len(M)
        p = [i for i in range(n)]
        for i in range(n):
            for j in range(n):
                if M[i][j] == 1:
                    self.union(p, i, j)
        return len(set([self.parent(p, i) for i in range(n)]))

    def union(self, p: List[int], i: int, j: int):
        pi = self.parent(p, i)
        pj = self.parent(p, j)
        p[pi] = pj

    def parent(self, p: List[int], i: int) -> int:
        node = i
        while p[node] != node:
            node = p[node]
        while p[i] != i:
            x = i
            i = p[i]
            p[x] = node
        return node
