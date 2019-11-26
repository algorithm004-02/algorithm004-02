# https://leetcode-cn.com/problems/fibonacci-number/

# 暴力递归法 自顶向下
# O(2^N)
class Solution:
    def fib(self, N: int) -> int:
        if N <= 1:
            return N
        return self.fib(N - 1) + self.fib(N - 2)


# 备忘录递归法 自顶向下
# O(N)
from typing import Mapping

class Solution:
    def fib(self, N: int) -> int:
        data = {}
        def _fib(N: int, data: Mapping):
            if N <= 1:
                return N
            if N not in data:
                data[N] = _fib(N - 1, data) + _fib(N - 2, data)
            return data[N]
        return _fib(N, data)


# 动态规划 自底向上
# O(N)
class Solution:
    def fib(self, N: int) -> int:
        if N == 0:
            return 0
        items = [0] * (N + 1)
        items[1] = 1
        for i in range(2, N + 1):
            items[i] = items[i - 1] + items[i - 2]
        return items[N]

