# https://leetcode-cn.com/problems/combinations/submissions/

class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        result = []
        self._combine(1, k, n, [], result)
        return result

    def _combine(self, start: int, k: int, n: int, items: List[int], result: List[List[int]]):
        if len(items) == k:
            result.append(items[:])
            return
        for i in range(start, n + 1):
            items.append(i)
            self._combine(i + 1, k, n, items, result)
            items.pop()
