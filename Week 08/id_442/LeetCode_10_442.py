# https://leetcode-cn.com/problems/regular-expression-matching/

class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        data = {}
        def dp(i: int, j: int) -> bool:
            if (i, j) in data:
                return data[(i, j)]

            if j == len(p):
                return i == len(s)

            first = i < len(s) and p[j] in {s[i], '.'}

            if j <= len(p) - 2 and p[j+1] == '*':
                r = dp(i, j+2) or first and dp(i+1, j)
            else:
                r = first and dp(i+1, j+1)
            data[(i, j)] = r
            return r
        return dp(0, 0)

