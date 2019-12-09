class Solution:
 
    def firstUniqChar(self, s: str) -> int:
        """
        遍历字符串中的字符，如果满足以下两个条件，则返回idx
        1. 该字符不存在于 s[:idx]
        2. 该字符不存在于 s[idx + 1:]
        :param s:
        :return:
        """
        for idx, c in enumerate(s):
            if c not in s[idx + 1:] and c not in s[:idx]:
                return idx
        return -1
