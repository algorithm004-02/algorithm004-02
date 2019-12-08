# https://leetcode.com/problems/find-all-anagrams-in-a-string/
# 438. Find All Anagrams in a String
class Solution:
  def findAnagrams(self, s: str, p: str) -> List[int]:
    sLen, pLen = len(s), len(p)
    if sLen < pLen: return []

    result = []
    sHash, pHash = [0] * 26, [0] * 26

    for i in range(pLen):
      sHash[ord(s[i]) - ord("a")] += 1 
      pHash[ord(p[i]) - ord("a")] += 1

    if sHash == pHash: result.append(0)

    for i in range(pLen, sLen):
      sHash[ord(s[i]) - ord("a")] += 1 
      sHash[ord(s[i - pLen]) - ord("a")] -= 1

      if sHash == pHash:
        result.append(i - pLen + 1)

    return result