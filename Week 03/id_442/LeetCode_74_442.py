# # https://leetcode-cn.com/problems/search-a-2d-matrix/submissions/

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix:
            return False

        row, col = len(matrix), len(matrix[0])
        left, right = 0, row * col - 1
        while left <= right:
            mid_idx = (left + right) >> 1
            mid_ele = matrix[mid_idx // col][mid_idx % col]
            if target == mid_ele:
                return True
            if target < mid_ele:
                right = mid_idx - 1
            else:
                left = mid_idx + 1
        return False
