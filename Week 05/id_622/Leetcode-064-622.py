"""
给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

说明：每次只能向下或者向右移动一步。

示例:

输入:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 7
解释: 因为路径 1→3→1→1→1 的总和最小。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-path-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

国际站经典：https://leetcode.com/problems/minimum-path-sum/discuss/23532/Python-Solution-with-Detailed-Explanation
"""
class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        m = len(grid)
        n = len(grid[0])
        # 边界情况，第一行，只能向右，只有一条路
        for i in range(1, n):
            grid[0][i] += grid[0][i-1]
        #grid = [[1,4,5], [1, 5, 1], [4, 2, 1]]
        # 边界情况，第一列，只能向下，只有一条路
        for i in range(1, m):
            grid[i][0] += grid[i-1][0]
        #grid = [[1, 4, 5], [2, 5, 1], [6, 2, 1]]

        for i in range(1, m):
            for j in range(1, n):
                grid[i][j] += min(grid[i-1][j], grid[i][j-1])

        return grid[-1][-1]