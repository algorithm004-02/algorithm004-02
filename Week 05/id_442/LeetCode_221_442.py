# https://leetcode-cn.com/problems/maximal-square/

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        rows, cols = len(matrix), len(matrix[0]) if len(matrix) > 0 else 0
        dp = [[0] * (cols + 1) for _ in range(rows + 1)]
        max_len = 0
        for i in range(1, rows + 1):
            for j in range(1, cols + 1):
                if matrix[i-1][j-1] == '1':
                    dp[i][j] = min(dp[i][j-1], dp[i-1][j], dp[i-1][j-1]) + 1
                    max_len = max(max_len, dp[i][j])
        return max_len * max_len
