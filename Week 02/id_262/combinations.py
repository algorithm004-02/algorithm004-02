from typing import List


class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        if n <= 0 or n < k or k <= 0:
            return []
        res = []
        self.lopper(res, [], 1, n, k)
        return res

    def lopper(self, res, l, level, n, k):
        if k == 0:
            res.append(l[:])
            return

        for i in range(level, n + 1):
            l.append(i)
            self.lopper(res, l, i + 1, n, k - 1)
            l.pop()


# class Solution:
#     def combine(self, n: int, k: int) -> List[List[int]]:
#         from itertools import combinations
#         res = []
#         res.append(list(combinations(range(1, n + 1), k)))
#         return res


s = Solution()
print(s.combine(n=4, k=3))
