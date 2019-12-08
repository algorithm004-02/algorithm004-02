from typing import List


class Solution:
    def uniquePathsWithObstacles1(self, obstacleGrid: List[List[int]]) -> int:
        if not obstacleGrid:
            return 0
        m = len(obstacleGrid)
        n = len(obstacleGrid[0])
        dp = [[0] * n for _ in range(m)]

        # 左上角
        dp[0][0] = 1 if obstacleGrid[0][0] != 1 else 0
        if dp[0][0] == 0:
            return 0
        # 第一行
        for row in range(1, n):
            if obstacleGrid[0][row] != 1:
                dp[0][row] = dp[0][row - 1]

        # 第一列
        for col in range(1, m):
            if obstacleGrid[col][0] != 1:
                dp[col][0] = dp[col - 1][0]

        for i in range(1, m):
            for j in range(1, n):
                if obstacleGrid[i][j] != 1:
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        return dp[-1][-1]
