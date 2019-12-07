# 242. Valid Anagram
# https://leetcode.com/problems/valid-anagram/solution/
# Approach 1: hash table
# time complexity: O(n), space complexity: O(1)
class Solution:
  def isAnagram(self, s: str, t: str) -> bool:
    if len(s) != len(t): return False
    sMap = dict(); tMap = dict()
    for c in s:
      sMap[c] = sMap.get(c, 0) + 1
    for c in t:
      tMap[c] = tMap.get(c, 0) + 1
    return sMap == tMap

class Solution:
  def isAnagram(self, s: str, t: str) -> bool:
    if len(s) != len(t): return False
    sMap = [0] * 26; tMap = [0] * 26
    for c in s:
      sMap[ord(c) - ord("a")] += 1
    for c in t:
      tMap[ord(c) - ord("a")] += 1
    return sMap == tMap

class Solution:
  def isAnagram(self, s: str, t: str) -> bool:
    if len(s) != len(t): return False
    map = [0] * 26
    for c in s:
      map[ord(c) - ord("a")] += 1
    for c in t:
      if map[ord(c) - ord("a")] < 0:
        return False
      map[ord(c) - ord("a")] -= 1
    return True

# Approach 2: build-in function
class Solution:
  def isAnagram(self, s: str, t: str) -> bool:
    return all([s.count(c) == t.count(c) for c in string.ascii_lowercase])

# Approach 3: sorting
# time complexity: O(nlog(n)), space complexity: O(1) 
class Solution:
  def isAnagram(self, s: str, t: str) -> bool:
    return sorted(s) == sorted(t)
