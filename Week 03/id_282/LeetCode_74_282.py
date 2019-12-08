class Solution:
    """
    二维数组转一维,用二分法
    二维变成一维,就是按照二维数组顺序,依次变成一维数列,所以有如果一个数在一维坐标位置是loc,那么它在二维坐标就是[loc/col][loc%col]
    """
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix: return False
        row = len(matrix)
        col = len(matrix[0])
        left = 0
        right = row * col
        while left < right:
            mid = left + (right - left) // 2
            if matrix[mid // col][mid % col] < target:
                left = mid + 1
            else:
                right = mid
        #print(left,right)
        return left < row * col and matrix[left // col][left % col] == target
