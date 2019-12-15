# https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/

# 动态规划 二维状态
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if not prices:
            return 0

        dp = [[0] * 2 for _ in range(len(prices))]

        # dp[i][0]: 第i天没有持有股票
        # 昨天没有股票 今天也不做任何操作
        # 昨天有股票 今天选择卖 所以今天也没有股票

        # dp[i][1]: 第i天持有股票
        # 昨天有股票 今天也不做任何操作
        # 昨天没有股票 今天选择买 所以今天持有了股票

        # dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
        # dp[i][k][1] = max(dp[i-1][k][0], dp[i-1][k-1][0] - prices[i])

        for i in range(len(prices)):
            # 第1天不会持有股票
            if i == 0:
                dp[i][1] = -prices[i]
                continue
            dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
            dp[i][1] = max(dp[i-1][1], -prices[i])
        return dp[-1][0]


# 动态规划 一维状态
import sys

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if not prices:
            return 0
        dp_i_0, dp_i_1 = 0, -sys.maxsize
        for i in range(len(prices)):
            dp_i_0 = max(dp_i_0, dp_i_1 + prices[i])
            dp_i_1 = max(dp_i_1, -prices[i])
        return dp_i_0

