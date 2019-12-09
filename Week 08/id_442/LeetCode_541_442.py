# https://leetcode-cn.com/problems/reverse-string-ii/

class Solution:
    def reverseStr(self, s: str, k: int) -> str:
        ls = list(s)
        for i in range(0, len(ls), 2*k):
            ls[i:i+k] = reversed(ls[i:i+k])
        return ''.join(ls)
