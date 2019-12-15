# https://leetcode.com/problems/first-unique-character-in-a-string/
# 387. First Unique Character in a String
class Solution:
  def firstUniqChar(self, s: str) -> int:
    hashMap = {}
    
    for c in s:
      hashMap[c] = hashMap.get(c, 0) + 1
    
    for i in range(len(s)):
      if hashMap[s[i]] == 1:
        return i
    
    return -1

class Solution:
  def firstUniqChar(self, s: str) -> int:
    index = [s.index(ch) for ch in string.ascii_lowercase if s.count(ch) == 1]
    
    return min(index) if len(index) else -1

class Solution:
  def firstUniqChar(self, s: str) -> int:
    idx = len(s)
    for ch in string.ascii_lowercase:
      l = s.find(ch)
      if l != -1 and l == s.rfind(ch):
        if l < idx:
          idx = l
    return idx if idx != len(s) else -1