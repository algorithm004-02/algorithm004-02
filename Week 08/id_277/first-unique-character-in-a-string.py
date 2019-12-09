class Solution(object):
    def firstUniqChar(self, s: str) -> int:
        # 计算字符出现次数
        dic = {c: s.count(c) for c in set(s)}

        # 找到并返回首个满足出现次数为一的字符
        for i, c in enumerate(s):
            if dic[c] == 1:
                return i
        return -1