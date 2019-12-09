class Solution:
    def firstUniqChar(self, s: str) -> int:
        index = [-1] * 26
        i, size = 0, len(s)
        for c in s:
            p = ord(c) - 97
            if index[p] >= 0:
                index[p] = size
            else:
                index[p] = i
            i += 1
        
        p = size
        for i in index:
            if 0 <= i < p:
                p = i
        return p if p < size else -1
        