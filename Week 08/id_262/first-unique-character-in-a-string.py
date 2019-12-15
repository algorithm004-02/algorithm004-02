class Solution:
    def firstUniqChar(self, s: str) -> int:
        from collections import OrderedDict
        res = OrderedDict()
        for item in s:
            res[item] = 1 if item not in res else res[item] + 1

        for key, value in res.items():
            if value == 1:
                return s.index(key)
        return -1
