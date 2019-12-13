#[64]最小路径和
#
#给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
#
# 说明：每次只能向下或者向右移动一步。 
#
# 示例: 
#
# 输入:
#[
#  [1,3,1],
#  [1,5,1],
#  [4,2,1]
#]
#输出: 7
#解释: 因为路径 1→3→1→1→1 的总和最小。
# 
# Related Topics 数组 动态规划


class Solution:
    def minPathSum(self, grid) -> int:

        if not grid or not grid[0]:
            return 0

        row, col = len(grid), len(grid[0])
        for i in range(1, row):
            grid[i][0] += grid[i - 1][0]

        for j in range(1, col):
            grid[0][j] += grid[0][j - 1]

        for i in range(1, row):
            for j in range(1, col):
                grid[i][j] += min(grid[i][j - 1], grid[i - 1][j])

        return grid[row - 1][col - 1]
