# https://leetcode-cn.com/problems/unique-paths/

# 暴力递归
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        if m <= 0 or n <= 0:
            return 0
        if m == 1 and n == 1:
            return 1
        return self.uniquePaths(m - 1, n) + self.uniquePaths(m, n - 1)


# 记忆化递归
from typing import Mapping

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        def fn(m: int, n: int, data: Mapping) -> int:
            if m <= 0 or n <= 0:
                return 0
            if m == 1 and n == 1:
                return 1
            if (m, n) not in data:
                data[(m, n)] = fn(m - 1, n, data) + fn(m, n - 1, data)
            return data[(m, n)]
        return fn(m, n, {})


# 动态规划
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [[0] * n for _ in range(m)]
        for i in range(m):
            dp[i][0] = 1
        for j in range(n):
            dp[0][j] = 1
        for i in range(1, m):
            for j in range(1, n):
                dp[i][j] = dp[i-1][j] + dp[i][j-1]
        return dp[-1][-1]


# 动态规划 优化空间复杂度
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [1] * n
        for i in range(1, m):
            for j in range(1, n):
                dp[j] += dp[j-1]
        return dp[-1]

