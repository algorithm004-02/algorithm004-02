class Solution:
    def firstUniqChar(self, s: str) -> int:
        dd , a = collections.Counter(s) , 0
        for i in s:
            if dd[i] == 1:
                return a
            else:
                a += 1
        return -1
