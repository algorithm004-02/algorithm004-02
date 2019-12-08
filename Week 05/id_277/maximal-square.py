class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if not matrix: return 0

        result = 0
        rows = len(matrix)
        columns = len(matrix[0])
        dp = [[0] * (columns + 1) for _ in range(rows + 1)]
        for i in range(1,rows+1):
            for j in range(1,columns+1):
                if matrix[i-1][j-1] == '1':
                    dp[i][j] = min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1]) + 1
                    result = max(result,dp[i][j] ** 2)
        return result