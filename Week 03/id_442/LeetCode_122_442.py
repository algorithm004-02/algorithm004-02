# https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/submissions/

# 贪心法
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        total = 0
        for i in range(1, len(prices)):
            if prices[i] > prices[i-1]:
                total += prices[i] - prices[i-1]
        return total
