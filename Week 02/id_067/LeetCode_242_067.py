#
# @lc app=leetcode.cn id=242 lang=python3
#
# [242] 有效的字母异位词
#

# @lc code=start
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s)!=len(t):
            return False
        result = [0]*26
        for i in s:
            result[ord(i) - ord('a')] += 1 
        for i in t:
            result[ord(i) - ord('a')] -= 1
        if result == [0]*26:
            return True
        else:
            return False
        
# @lc code=end

