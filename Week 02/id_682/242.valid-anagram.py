class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if  len(s) != len(t):
            return False
        
        res = {}
        for i in s:
            if i in res:
                res[i] += 1
            else:
                res[i] = 1
        
        for j in t:
            if j in res:
                res[j] -= 1
            else:
                return False
        
        for check in res:
            if res[check] != 0:
                return False
        return True