#贪心

class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if not prices :return 0
        tt=len(prices)

        count=0
        for  i in range (1,tt):
            if prices[i-1] <prices[i]:
                count+=prices[i]-prices[i-1]
        return count

