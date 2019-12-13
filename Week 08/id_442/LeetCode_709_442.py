# https://leetcode-cn.com/problems/to-lower-case/

class Solution:
    def toLowerCase(self, str: str) -> str:
	# 大写变小写、小写变大写 : ASCII码 ^= 32
        # 大写变小写、小写变小写 : ASCII码 |= 32
        # 小写变大写、大写变大写 : ASCII码 &= -33
        r = []
        for i in str:
            l = chr(ord(i) | 32)
            r.append(l)
        return ''.join(r)
