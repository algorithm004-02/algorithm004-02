#Leetcode 242
#Python solution:

# Sort Solution: Running time 0(nlogn)
def isAnagram(self, s: str, t: str) -> bool:
        s = sorted(s)
        t = sorted(t)
        if s == t:
            return True
        else:
            return False

def isAnagram(self, s: str, t: str) -> bool:
    if len(s) != len(t):
        return False
    return sorted(s) == sorted(t)

