# https://leetcode-cn.com/problems/merge-intervals/

class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals = sorted(intervals)
        result, i, size = [], 0, len(intervals)
        while i < size:
            left, right = intervals[i][0], intervals[i][1]
            while i < size - 1 and intervals[i+1][0] <= right:
                i += 1
                right = max(intervals[i][1], right)
            result.append((left, right))
            i += 1
        return result
