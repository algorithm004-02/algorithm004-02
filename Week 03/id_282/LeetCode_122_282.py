class Solution:
    """
    解法 贪心算法
    由于可以在同一天卖出和买入，这相当于没有卖出，连续买。因此只要比对当前与前一天的价格（即这两天能获得的利润），
    如果是上升的就加上，如果是下降的则取0，最后所有的连续日利润的和就是最大利润。
    """
    def maxProfit(self, prices: List[int]) -> int:
        max_profit = 0
        for i in range(len(prices)-1):
            max_profit += max(0, prices[i+1]-prices[i])
        return max_profit
