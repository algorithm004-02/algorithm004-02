from collections import Counter
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        return Counter(s)==Counter(t)

if __name__=="__main__":
    s1=Solution()
    print(s1.isAnagram(s = "anagram", t = "nagaram"))