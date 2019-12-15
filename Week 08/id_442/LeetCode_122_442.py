# https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/

# 动态规划 二维状态
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if not prices:
            return 0

        dp = [[0] * 2 for _ in range(len(prices))]
        for i in range(len(prices)):
            if i == 0:
                dp[i][1] = -prices[i]
                continue
            dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
            dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i])
        return dp[-1][0]

# 动态规划 一维状态
import sys

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if not prices:
            return 0

        dp_i_0, dp_i_1 = 0, -sys.maxsize
        for i in range(len(prices)):
            tmp = dp_i_0
            dp_i_0 = max(dp_i_0, dp_i_1 + prices[i])
            dp_i_1 = max(dp_i_1, tmp - prices[i])
        return dp_i_0
