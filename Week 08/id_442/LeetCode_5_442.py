# https://leetcode-cn.com/problems/longest-palindromic-substring/submissions/

# 中间向两边扩散
class Solution:
    def longestPalindrome(self, s: str) -> str:
        size = len(s)
        if size < 2:
            return s

        max_len, res = 0, s[0]
        for i in range(size):
            palindrome_odd, odd_len = self.helper(s, i, i)
            palindrome_even, even_len = self.helper(s, i, i+1)
            cur_max_sub = palindrome_odd if odd_len >= even_len else palindrome_even
            if len(cur_max_sub) > max_len:
                max_len = len(cur_max_sub)
                res = cur_max_sub
        return res

    def helper(self, s: str, i: int, j: int):
        while i >= 0 and j < len(s) and s[i] == s[j]:
            i -= 1
            j += 1
        return s[i+1:j], j-i-1


# 动态规划
class Solution:
    def longestPalindrome(self, s: str) -> str:
        size, res = len(s), ''
        dp = [[False] * size for _ in range(size)]
        for i in range(size-1, -1, -1):
            for j in range(i, size):
                dp[i][j] = s[i] == s[j] and (j - i < 2 or dp[i+1][j-1])
                if dp[i][j] and j - i + 1 > len(res):
                    res = s[i:j+1]
        return res

