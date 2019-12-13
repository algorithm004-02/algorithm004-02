# https://leetcode-cn.com/problems/valid-palindrome-ii/

class Solution:
    def validPalindrome(self, s: str) -> bool:
        i, j = 0, len(s) - 1
        while i < j and s[i] == s[j]:
            i += 1
            j -= 1
        if self.valid(s, i+1, j) or self.valid(s, i, j-1):
            return True
        return False

    def valid(self, s: str, i: int, j: int) -> bool:
        while i < j:
            if s[i] != s[j]:
                return False
            i += 1
            j -= 1
        return True
