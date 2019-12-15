# https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/

import sys

# 动态规划 三维空间
class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        if not prices:
            return 0

        # 买卖至少2天可以完成
        # 如果交易次数超过股票天数的一半 相当于转化为k为正无穷的解法
        # 直接把之前求解k为正无穷的方法拿过来调用即可
        # 否则这里会提示超过时间限制
        if k > len(prices) / 2:
            return self.max_profit_inf(prices)

        dp = [[[0] * 2 for _ in range(k+1)] for _ in range(len(prices))]
        for i in range(len(prices)):
            for _k in range(k, 0, -1):
                if i == 0:
                    dp[i][_k][1] = -prices[i]
                    continue
                dp[i][_k][0] = max(dp[i-1][_k][0], dp[i-1][_k][1] + prices[i])
                dp[i][_k][1] = max(dp[i-1][_k][1], dp[i-1][_k-1][0] - prices[i])
        return dp[-1][k][0]

    # 交易次数不限制的解法
    def max_profit_inf(self, prices: List[int]) -> int:
        dp_i_0, dp_i_1 = 0, -sys.maxsize
        for i in range(len(prices)):
            tmp = dp_i_0
            dp_i_0 = max(dp_i_0, dp_i_1 + prices[i])
            dp_i_1 = max(dp_i_1, tmp - prices[i])
        return dp_i_0
