# https://leetcode-cn.com/problems/climbing-stairs/

# 暴力递归
class Solution:
    def climbStairs(self, n: int) -> int:
        if n <= 2:
            return n
        return self.climbStairs(n - 1) + self.climbStairs(n - 2)


# 记忆化递归
from typing import Mapping

class Solution:
    def climbStairs(self, n: int) -> int:
        def fn(n: int, data: Mapping) -> int:
            if n <= 2:
                return n
            if n not in data:
                data[n] = fn(n - 1, data) + fn(n - 2, data)
            return data[n]
        return fn(n, {})

# 动态规划
class Solution:
    def climbStairs(self, n: int) -> int:
        if n <= 2:
            return n
        dp = [1] * (n + 1)
        for i in range(2, n + 1):
            dp[i] = dp[i - 1] + dp[i - 2]
        return dp[n]


# 动态规划 优化空间复杂度
class Solution:
    def climbStairs(self, n: int) -> int:
        if n <= 2:
            return n
        f1, f2 = 1, 2
        for i in range(3, n + 1):
            f3 = f1 + f2
            f1, f2 = f2, f3
        return f3
