"""
给出一个区间的集合，请合并所有重叠的区间。

示例 1:

输入: [[1,3],[2,6],[8,10],[15,18]]
输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例 2:

输入: [[1,4],[4,5]]
输出: [[1,5]]
解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-intervals
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
class Solution(object):
    def merge(self, intervals):
        """
        :type intervals: List[List[int]]
        :rtype: List[List[int]]
        """
        intervals = sorted(intervals)
        n = len(intervals)
        res = []
        i = 0
        while i < n:
            left = intervals[i][0]
            right = intervals[i][1]
            """
            此段代码的边界判断太清晰了。。。。。。
            先判断前一个值的右边界与下一个左边界的大小
            如果前一个的右边界小于后一个的左边界，则两个需要合并
            此时考虑右边界值中大的一个，
            否则进入下一个数比较
            """
            while i < n - 1 and intervals[i + 1][0] <= right:
                i += 1
                right = max(intervals[i][1], right)
            res.append([left, right])
            i += 1
        return res