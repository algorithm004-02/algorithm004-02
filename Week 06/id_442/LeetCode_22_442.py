# https://leetcode-cn.com/problems/generate-parentheses/

# DFS
class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        result = []
        self._generate(n, 0, 0, '', result)
        return result

    def _generate(self, n: int, left: int, right: int, s: str, result: List[str]):
        if len(s) == 2 * n:
            result.append(s)
	# 剪枝 去掉无用的分支
        if left < n:
            self._generate(n, left + 1, right, s + '(', result)
        if right < left:
            self._generate(n, left, right + 1, s + ')', result)

# BFS
from collections import deque

class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        result, queue = [], deque([(0, 0, '')])
        while queue:
            left, right, s = queue.popleft()
            if len(s) == 2 * n:
                result.append(s)
	    # 剪枝
            if left < n:
                queue.append((left + 1, right, s + '('))
            if right < left:
                queue.append((left, right + 1, s + ')'))
        return result


# DP 自底向上
class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        if n == 0:
            return []
        dp = [None for _ in range(n+1)]
        dp[0] = ['']

        # DP 自底向上
        for i in range(1, n+1):
            current = []
            for j in range(i):
                left, right = dp[j], dp[i-j-1]
                for s1 in left:
                    for s2 in right:
                        current.append('(' + s1 + ')' + s2)
            dp[i] = current

        return dp[n]

