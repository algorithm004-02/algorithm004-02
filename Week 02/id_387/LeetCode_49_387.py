# 49. Group Anagrams
# https://leetcode.com/problems/group-anagrams/
# Approach 1: Categorize by Sorted String
# time complexity: O(nklog(k)), space complexity: O(nk)
# n is the length of strs, k is the maximum length of a string in strs. 
# sort each string in O(klog(k))
class Solution:
  def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
    if not strs: return []
    res = collections.defaultdict(list)
    for str in strs:
      res[tuple(sorted(str))].append(str)
    return res.values()

# time complexity: O(nk, space complexity: O(nk)
# Approach 2: Categorize by Count
class Solution:
  def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
    if not strs: return []
    res = collections.defaultdict(list)
    for str in strs:
      map = [0] * 26
      for s in str:
        map[ord(s) - ord("a")] += 1
      res[tuple(map)].append(str)
    return res.values()