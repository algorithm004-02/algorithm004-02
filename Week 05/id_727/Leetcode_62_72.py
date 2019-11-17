# Naive Solution: Space: O(n^2)
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        res = [[0 for i in range(m)] for j in range(n)]
        
        for i in range(m):
            res[n-1][i] = 1
        for j in range(n):
            res[j][m-1] = 1
            
        for j in range(n-1):
            for i in range(m-1):
                res[n-2-j][m-2-i] =   res[n-2-j][m-1-i] + res[n-1-j][m-2-i]              
        return res[0][0] 

# Space O(2n) Solution
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        pre = [1] * n
        cur = [1] * n
        for i in range(1,m):
            for j in range(1,n):
                cur[j] = cur[j -1] + pre[j]
            pre = cur[:]
        return cur[n-1]