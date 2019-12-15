# https://leetcode-cn.com/problems/valid-anagram/

# 排序比较
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        return sorted(s) == sorted(t)


# 比较ASCII码距a的距离
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        arr1, arr2 = [0] * 26, [0] * 26
        for i in s:
            arr1[ord(i) - ord('a')] += 1
        for j in t:
            arr2[ord(j) - ord('a')] += 1
        return arr1 == arr2
