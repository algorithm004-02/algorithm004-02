#
# @lc app=leetcode.cn id=242 lang=python3
#
# [242] 有效的字母异位词
#

# @lc code=start
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if sorted(s) != sorted(t):
            return False
        else:
            return True
        
# @lc code=end

