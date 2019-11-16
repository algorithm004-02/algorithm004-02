# https://leetcode-cn.com/problems/assign-cookies/submissions/

class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        if not g or not s:
            return 0

        # 排序
        g.sort()
        s.sort()

        # 优先满足胃口小的孩子
        gi, si = 0, 0
        while gi < len(g) and si < len(s):
            if g[gi] <= s[si]:
                gi += 1
            si += 1
        return gi
