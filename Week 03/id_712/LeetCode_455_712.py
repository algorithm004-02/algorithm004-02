class Solution:
    def findContentChildren(self, g,s):
        g.sort()
        s.sort()
        childi=0
        cookiei=0
        while cookiei<len(s) and childi<len(g):
            if s[cookiei]>=g[childi]:
                childi+=1
            cookiei+=1
        return childi
