# 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
# 示例 1:
# 输入: s = "anagram", t = "nagaram"
# 输出: true
# 示例 2:
# 输入: s = "rat", t = "car"
# 输出: false

class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        
        d = {}
        for value in s:
            if value in d:
                d[value] += 1 
            else:
                d[value] = 1
            
        for value in t:
            if value in d:
                d[value] -= 1
            else:
                return False
    
        for value in d:
            if d[value] != 0:
                return False
        
        return True
