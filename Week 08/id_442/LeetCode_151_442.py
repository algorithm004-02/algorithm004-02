# https://leetcode-cn.com/problems/reverse-words-in-a-string/

class Solution:
    def reverseWords(self, s: str) -> str:
        # 反转整个字符串
        s = ''.join(reversed(s))
        r = []
        for i in s.split():
            # 每个单词再反转
            r.append(''.join(reversed(i)))
        return ' '.join(r)
