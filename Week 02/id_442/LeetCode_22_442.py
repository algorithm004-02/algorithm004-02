# https://leetcode-cn.com/problems/generate-parentheses/submissions/

class Solution:

    def generateParenthesis(self, n: int) -> List[str]:
        result = []
        self._generate(0, 0, n, '', result)
        return result

    def _generate(self, left: int, right: int, n: int, s: str, result: List[str]):
        if len(s) == n * 2:
            result.append(s)
            return
        if left < n:
            self._generate(left + 1, right, n, s + '(', result)
        if right < left:
            self._generate(left, right + 1, n, s + ')', result)
