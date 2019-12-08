#[221]最大正方形
#
#在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
#
# 示例: 
#
# 输入: 
#
#1 0 1 0 0
#1 0 1 1 1
#1 1 1 1 1
#1 0 0 1 0
#
#输出: 4 
# Related Topics 动态规划


class Solution:
    def maximalSquare(self, matrix) -> int:

        if not matrix:
            return 0

        row, col = len(matrix) + 1, len(matrix[0]) + 1
        dp = [[0] * col for _ in range(row)]

        max_len = 0

        for i in range(1, row):
            for j in range(1, col):
                if matrix[i - 1][j - 1] == '1':
                    dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1
                    max_len = max(max_len, dp[i][j])

        return max_len * max_len

sorted()