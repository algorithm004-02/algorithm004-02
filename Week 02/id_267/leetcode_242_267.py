# 有效的字母异位词 anagram
# 刷题四件套：
# 1. clarification
# 2. possible solutions --> optimal (time & space)
# 3. code
# 4. test cases
#
# 1. 暴力， sort, sorted_str 相等？ O(NlogN)
# 2. hash, map --> 统计每个字符的频次
############################暴力######################
# 执行用时 :72 ms
# class Solution:
#     def isAnagram(self, s: str, t: str) -> bool:
#         result = True
#         if sorted(s) != sorted(t):
#             result = False
#         return (result)
###################set##########################
# 执行用时 :52 ms
# 1. 先将去重后的字符串比较是否相等（用set）
# 2. 循环比较字符串中字符的个数是否相等
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        result = True
        set_tmp = set(s)
        if set_tmp == set(t):
            for i in set_tmp:
                result = result and (s.count(i) == t.count(i))
        else:
            result = False
        return(result)


################test cases##############
s = 'anagram'
t = 'nagaram'
obj = Solution()
print(obj.isAnagram(s, t))
################学习到的技巧######################
# 1. 如函数的返回值是bool，可先定义个返回值的默认值
