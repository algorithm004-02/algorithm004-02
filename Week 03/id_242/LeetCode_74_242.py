#
# @lc app=leetcode id=74 lang=python3
#
# [74] Search a 2D Matrix
#

# @lc code=start
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)
        if m <= 0:
            return False
        n = len(matrix[0])
        left = 0
        right = m * n - 1
        while left <= right:
            mid = (left + right) // 2
            mid_elem = matrix[int(mid/n)][int(mid%n)]
            if target == mid_elem:
                return True
            if target < mid_elem:
                right = mid - 1
            else:
                left = mid + 1
        return False
        
# @lc code=end

