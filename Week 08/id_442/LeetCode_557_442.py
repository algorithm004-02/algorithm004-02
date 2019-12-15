# https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/

class Solution:
    def reverseWords(self, s: str) -> str:
        r = []
        for i in s.split():
            r.append(''.join(reversed(i)))
        return ' '.join(r)
