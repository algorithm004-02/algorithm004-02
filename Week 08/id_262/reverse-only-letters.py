class Solution:
    def reverseOnlyLetters(self, S: str) -> str:
        start, end = 0, len(S) - 1
        str_list = set("QWERTYUIOPLKJHGFDSAZXCVBNMqwertyuioplkjhgfdsazxcvbnm")
        s = [item for item in S]
        for _ in s:
            if start >= end:
                break
            if s[start] in str_list and s[end] in str_list:
                s[start], s[end] = s[end], s[start]
                start += 1
                end -= 1
            elif s[start] in str_list and s[end] not in str_list:
                end -= 1
            elif s[start] not in str_list and s[end] in str_list:
                start += 1
            else:
                start += 1
                end -= 1
        return "".join(s)
