#
# @lc app=leetcode id=91 lang=python3
#
# [91] Decode Ways
#

# @lc code=start
class Solution:
    def numDecodings(self, s: str) -> int:
        n = len(s)
        if not s or s[0] == '0':
            return 0
        pre, cur = 1, 1
        for i in range(1, n):
            tmp = cur
            if s[i] == '0':
                if s[i-1] == '1'  or s[i-1] == '2':
                    cur = pre
                else:
                    return 0
            elif s[i-1] == '1' or (s[i-1] == '2' and int(s[i]) >=1 and int(s[i]) <= 6):
                cur += pre
            pre = tmp
        return cur
        
# @lc code=end

