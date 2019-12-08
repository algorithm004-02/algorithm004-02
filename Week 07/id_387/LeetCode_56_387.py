# https://leetcode.com/problems/merge-intervals/
# 56. Merge Intervals
class Solution:
  def merge(self, intervals: List[List[int]]) -> List[List[int]]:
    if len(intervals) == 0: return []
    merged = []
    for interval in sorted(intervals):
      if merged and merged[-1][1] >= interval[0]:
        merged[-1][1] = max(merged[-1][1], interval[1])
      else:
        merged.append(interval)
    return merged