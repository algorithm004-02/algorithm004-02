from typing import List


class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        def _helper(s, left, right):
            if len(s) == 2 * n:
                res.append(s)
            if left < n:
                _helper(s + "(", left + 1, right)
            if right < left:
                _helper(s + ")", left, right + 1)

        res = []
        _helper("", 0, 0)
        return res
