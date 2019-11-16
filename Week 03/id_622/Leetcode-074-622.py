"""
编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：

每行中的整数从左到右按升序排列。
每行的第一个整数大于前一行的最后一个整数。
示例 1:

输入:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
输出: true
示例 2:

输入:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
输出: false

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/search-a-2d-matrix
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        row_low = 0
        row_high = len(matrix) - 1
        col_low = 0
        if not matrix or not matrix[0]: return False
        
        if not (matrix[0][0] <= target <= matrix[-1][-1]) : return False
        
        while row_low <= row_high: # 边界条件
            mid = (row_low + row_high) // 2
            
            if matrix[mid][col_low] <= target and matrix[mid][-1] >= target:
                # 在找到的行之中，继续查找
                col_hi = len(matrix[mid]) - 1
                while col_low <= col_hi:
                    mid_row = (col_low + col_hi) // 2
                    if matrix[mid][mid_row] == target:
                        return True
                    if matrix[mid][mid_row] > target:
                        col_hi = mid_row - 1
                    if matrix[mid][mid_row] < target:
                        col_low = mid_row + 1
                return False
            elif matrix[mid][col_low] > target:
                row_high = mid - 1 # 边界
            elif matrix[mid][-1] < target:
                row_low = mid + 1 # 边界
            else:
                return False
        return False

    # 方法二、变成一行
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix or not matrix[0]: return False
        
        m = len(matrix)
        n = len(matrix[0])
        
        left, right = 0, m * n - 1
        while left <= right:
            pivot_idx = (left + right) // 2
            pivot_element = matrix[pivot_idx // n][pivot_idx % n]
            if target == pivot_element:
                return True
            else:
                if target < pivot_element:
                    right = pivot_idx - 1
                else:
                    left = pivot_idx + 1
        return False