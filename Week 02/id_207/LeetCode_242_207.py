# [242] 有效的字母异位词
# 思路：通过python的set数据结构，去重去序；在通过判断两个字符串中各字符出现的次数来判断是否为异位词
#
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        result = True
        set_tmp = set(s)
        if set_tmp == set(t):
            for i in set_tmp:
                result = result and (s.count(i) == t.count(i))
        else:
            result = False
        
        return result