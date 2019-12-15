# https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/

# 动态规划 三维状态
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if not prices:
            return 0
        max_k = 2
        dp = [[[0] * 2 for _ in range(max_k+1)] for _ in range(len(prices))]
        for i in range(len(prices)):
            for k in range(max_k, 0, -1):
                if i == 0:
                    dp[i][k][1] = -prices[i]
                    continue
                dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
                dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
        return dp[-1][max_k][0]


# 动态规划 一维状态
import sys

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if not prices:
            return 0
        dp_i_2_0, dp_i_2_1 = 0, -sys.maxsize
        dp_i_1_0, dp_i_1_1 = 0, -sys.maxsize
        for i in range(len(prices)):
            dp_i_2_0 = max(dp_i_2_0, dp_i_2_1 + prices[i])
            dp_i_2_1 = max(dp_i_2_1, dp_i_1_0 - prices[i])
            dp_i_1_0 = max(dp_i_1_0, dp_i_1_1 + prices[i])
            dp_i_1_1 = max(dp_i_1_1, -prices[i])
        return dp_i_2_0
