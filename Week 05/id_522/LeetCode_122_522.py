
# 68ms   99.4%

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        benefit =0
        for i in range(len(prices)-1):
            t=prices[i+1] - prices[i]
            if t>0: benefit += t
        return benefit



'''

class Solution:
    def maxProfit(self, p):
        b =0
        for i in range(len(p)-1):
            t=p[i+1] - p[i]
            if t>0: b += t  
        return b


---------------------------------

class Solution:
    def maxProfit(self,p):
        b=0
        s=len(p)-1
        for i in range(s):
            t=p[i+1]-p[i]
            if t>0:b+=t  
        return b
'''
