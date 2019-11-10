#
# @lc app=leetcode.cn id=122 lang=python3
#
# [122] 买卖股票的最佳时机 II
#

# @lc code=start
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        flag, stock, profit = 0, 0, 0
        for n in range(1,len(prices)):
            if flag ==0:
                if prices[n - 1] < prices[n]:
                    stock = prices[n - 1]
                    flag = 1
            else:
                if prices[n - 1] > prices[n]:
                    profit = profit + prices[n - 1] - stock
                    flag = 0
        if flag == 1:
            profit = profit + prices[-1] - stock
            flag = 0
        return profit

"""
    def maxProfit(self, prices: List[int]) -> int:
        profit = 0
        for i in range(1, len(prices)):
            tmp = prices[i] - prices[i - 1]
            if tmp > 0: profit += tmp
        return profit

"""
        
# @lc code=end

