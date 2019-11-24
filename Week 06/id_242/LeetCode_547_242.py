#
# @lc app=leetcode id=547 lang=python3
#
# [547] Friend Circles
#

# @lc code=start
class Solution:
    def findCircleNum(self, M: List[List[int]]) -> int:
        if not M or not M[0]:
            return 0
        n = len(M)
        visited = [0] * n
        count = 0

        # DFS
        # for i in range(n):
        #     if visited[i] == 0:
        #         self.dfs(M, visited, i)
        #         count += 1

        # BFS
        # queue = []
        # for i in range(n):
        #     if visited[i] == 0:
        #         queue.append(i)
        #         while queue:
        #             s = queue.pop()
        #             visited[s] = 1
        #             for j in range(n):
        #                 if M[s][j] == 1 and visited[j] == 0:
        #                     visited[j] = 1
        #                     queue.append(j)
        #         count += 1

        # DJ Set
        parents = [-1] * n
        for i in range(n):
            for j in range(n):
                if M[i][j] == 1 and i != j:
                    self.union(parents, i, j)
        count = len(list(filter(lambda parent:parent == -1, parents)))
        return count

    def find(self, parents: List[int], i) -> int:
        if parents[i] == -1:
            return i
        return self.find(parents, parents[i])

    def union(self, parents: List[int], x: int, y: int):
        xset = self.find(parents, x)
        yset = self.find(parents, y)
        if xset != yset:
            parents[xset] = yset

    # def dfs(self, M: List[List[int]], visited: List[int], i: int):
    #     for j in range(len(M)):
    #         if M[i][j] == 1 and visited[j] == 0:
    #             visited[j] = 1
    #             self.dfs(M, visited, j)

# @lc code=end

