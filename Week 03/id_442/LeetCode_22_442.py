# https://leetcode-cn.com/problems/generate-parentheses/

# DFS实现
class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        result = []
        self._generate(0, 0, n, '', result)
        return result

    def _generate(self, left: int, right: int, n: int, s: str, result: str):
        if len(s) == n * 2:
            result.append(s)
            return
        if left < n:
            self._generate(left + 1, right, n, s + '(', result)
        if right < left:
            self._generate(left, right + 1, n, s + ')', result)

# BFS实现
from collections import deque

class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        result, queue, i = [], deque([('', 0, 0)]), 0

        while i < 2 * n:
            for j in range(len(queue)):
                s, left, right = queue.popleft()
                if left < n:
                    queue.append((s + '(', left + 1, right))
                if right < left:
                    queue.append((s + ')', left, right + 1))
            i += 1

        while queue:
            result.append(queue.popleft()[0])
        return result
