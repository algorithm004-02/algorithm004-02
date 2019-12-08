class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        d = {}
        for i in s:
            if i in d:
                d[i] += 1
                continue
            d[i] = 1

        for j in t:
            if j not in d:
                return False
            d[j] -= 1
            if d[j] < 0:
                return False
        for key, value in d.items():
            if value != 0:
                return False
        return True
