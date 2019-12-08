# https://leetcode-cn.com/problems/first-unique-character-in-a-string/

# 暴力法
class Solution:
    def firstUniqChar(self, s: str) -> int:
        for i, s1 in enumerate(s):
            flag = False
            for j, s2 in enumerate(s):
                if i == j:
                    continue
                if s1 == s2:
                    flag = True
                    break
            if not flag:
                return i
        return -1

# 哈希法
class Solution:
    def firstUniqChar(self, s: str) -> int:
        data = {}
        for i in s:
            if i not in data:
                data[i] = 1
            else:
                data[i] += 1
        for idx, j in enumerate(s):
            if data[j] == 1:
                return idx
        return -1
