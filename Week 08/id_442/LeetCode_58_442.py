# https://leetcode-cn.com/problems/length-of-last-word/

class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        if not s.strip():
            return 0
        return len(s.split()[-1])
