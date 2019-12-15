#
# @lc app=leetcode id=5 lang=python3
#
# [5] Longest Palindromic Substring
#

# @lc code=start
class Solution:
    def longestPalindrome(self, s: str) -> str:
        if not s:
            return ""
        l = len(s)
        if l < 2:
            return s
        start, end = 0, 0
        for i in range(l):
            odd = self.expandCenter(i, i, s)
            even = self.expandCenter(i, i+1, s)
            length = max(odd, even)
            if length > end - start:
                start = i - ((length - 1) >> 1)
                end = i + (length >> 1)
        return s[start:end+1]


    def expandCenter(self, left: int, right: int, s: str) -> int:
        l, r = left, right
        while l >=0 and r < len(s):
            if s[l] == s[r]:
                l -= 1
                r += 1
            else:
                break
        return r -l - 1
        
# @lc code=end

