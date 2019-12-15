# https://leetcode-cn.com/problems/min-cost-climbing-stairs/

# 动态规划 二维状态
class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        if len(cost) < 2:
            return 0
        dp = [0] * len(cost)
        dp[0] = cost[0]
        dp[1] = cost[1]
        for i in range(len(cost)):
            dp[i] = min(dp[i-1], dp[i-2]) + cost[i]
        return min(dp[-1], dp[-2])
