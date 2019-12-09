# https://leetcode-cn.com/problems/isomorphic-strings/

class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        for i in range(len(s)):
            if s.index(s[i]) != t.index(t[i]):
                return False
        return True
