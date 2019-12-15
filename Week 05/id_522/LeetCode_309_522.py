# 涉及到了前天的事情，所以，需要处理四个变量。一天记录2个变量。两天的，昨天和前天的。
#疯了一样的压缩，然后，先后顺序调整，把6次赋值，变为4次 ，变量名精简，当然要写注释多，看第21行吧
#执行用时 :40 ms, 在所有 python3 提交中击败了99.71%的用户
class Solution:
    def maxProfit(self,p):
        s=0
        s2=0
        b=-99999
        b2=0
        for v in p:
            b2=b
            if b<s2-v:b=s2-v
            s2=s
            if s<b+v:s=b+v
        return s

#精简，执行用时 :44 ms, 在所有 python3 提交中击败了99.12%的用户
'''
class Solution:
    def maxProfit(self, p):
        s1=0   #昨天卖出后
        s2=0   #前天卖出后
        b1=-99999   #昨天买入后的收益
        b2=-99999   #前天买入后的收益   2 是向左两天的意思
        for v in p:
            ts1=s1
            tb1=b1
            if s1<b1+v:s1=b1+v  #不使用max()
            if b1<s2-v:b1=s2-v
            s2=ts1
            b2=tb1
        return s1
'''
#1th
'''
class Solution:
    def maxProfit(self, p: List[int]) -> int:

        s1=0
        s2=0
        b1=-99999
        b2=-99999

        for i,v in enumerate(p) :
            ts1=s1
            tb1=b1

            s1=max(s1,b1+v)
            b2=b1
            b1=max(b1,s2-v)

            s2=ts1
            b2=tb1
        return s1


看了国际站，感觉写的好，，思考人家4次赋值，就搞定了。

def maxProfit(self, prices):
    if len(prices) < 2:
        return 0
    sell, buy, prev_sell, prev_buy = 0, -prices[0], 0, 0
    for price in prices:
        prev_buy = buy
        buy = max(prev_sell - price, prev_buy)
        prev_sell = sell
        sell = max(prev_buy + price, prev_sell)
    return sell

'''
'''
#44ms
class Solution:  
    def maxProfit(self,pp):
        if len(pp)<2:return 0
        s, buy, prev_sell, prev_buy = 0, -pp[0], 0, 0
        for p in pp:
            prev_buy=buy
            buy = max(prev_sell-p,buy)
            prev_sell=s
            s = max(prev_buy + p,s)
        return s
'''
