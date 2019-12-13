# https://leetcode-cn.com/problems/unique-paths-ii/

class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        width = len(obstacleGrid[0])
        dp = [0] * width
        dp[0] = 1
        for row in obstacleGrid:
            for i in range(width):
                if row[i] == 1:
                    dp[i] = 0
                elif i > 0:
                    dp[i] += dp[i-1]
        return dp[width-1]

