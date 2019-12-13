"""
给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

示例 1:

输入: s = "anagram", t = "nagaram"
输出: true
示例 2:

输入: s = "rat", t = "car"
输出: false
说明:
你可以假设字符串只包含小写字母。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-anagram
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""

class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        # 暴力法
        if len(s) == 0 and len(t) == 0: return True
        dict = {}
        for x in s:
            if x not in dict:
                dict[x] = 1
            else:
                dict[x] += 1

        for x1 in t:
            if x1 not in dict:
                return False
            else:
                if dict.get(x1) == 0:
                    del dict[x1]
                else:
                    dict[x1] -= 1
                    if dict[x1] == 0:
                        del dict[x1]
        
        return not dict