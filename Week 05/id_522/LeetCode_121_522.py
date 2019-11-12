# 121

# 第四版  ,连max 也不用 。 执行用时 :68 ms, 在所有 python3 提交中击败了99.67%的用户

#国际站 Runtime: 64 ms, faster than 97.11% of Python3 online submissions for Best Time to Buy and Sell Stock.
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if not prices: return 0
        x = 0
        y = -prices[0]
        for v in prices:
            # x,y = max(x,y+v) ,max(y,-v)
            if -v > y:
                y = -v
            if y + v > x:
                x = y + v
        return x


# 第一次  ，使用 棘轮 原理
'''
class Solution(object):
    def maxProfit(self, prices):
        if not prices :return 0
        kk=len(prices)
        if kk==1 :return 0

        dp =[0 for _ in range(kk)]
        res=0
        themin=prices[0]
        
        for i in range(1,kk):
            if prices[i]<themin:
                themin= prices[i]
            
            #dp[i]=prices[i]- min(prices[:i] )
            dp[i]=prices[i]- themin 
            if res < dp[i] :
                res=dp[i]
        return res

'''

# 第二次
'''
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if not prices :return 0
        dp=[[0,-prices[0]] for _ in range(len(prices)+1)  ]

        for i,v in enumerate(prices):
            dp[i+1][0]= max(dp[i][0] , dp[i][1]+v )
            dp[i+1][1]= max(dp[i][1],-v)
            #dp[i+1][1]= max(dp[i][1],dp[i][0]-v)
            #在k的简化中，把三维，降低为2维，但是，任何的dp[i][0][0] = 0 ，中间的k=0
            #就是没有买过股票，手里也没有股票，赚了0元。
        return dp[i+1][0]

'''

# 第三次 ，状态压缩 ，利用python 优势 ,沿袭 斐波那契数列的写法
'''
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if not prices :return 0
        x=0
        y=float("-inf")
        for v in prices:
            x,y = max(x,y+v) ,max(y,-v)
        return x
'''
