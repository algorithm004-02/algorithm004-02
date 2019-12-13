# https://leetcode-cn.com/problems/reverse-only-letters/

class Solution:
    def reverseOnlyLetters(self, S: str) -> str:
        i, j = 0, len(S) - 1
        r = []
        for i, x in enumerate(S):
            if x.isalpha():
                while not S[j].isalpha():
                    j -= 1
                r.append(S[j])
                j -= 1
            else:
                r.append(x)
        return ''.join(r)
