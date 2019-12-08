#看了官方题解，发现如果用嵌套循环，再处理下标，很容易出错
# 对于每一个 DP[i] 其实就是记录四个变量


#精简，提速 执行用时 :88 ms, 在所有 python3 提交中击败了97.24%的用户
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        #because  kmax=2
        # use four Variables
        #a 交易了两次，第二次卖出后，收益
        #c  交易了两次，第二次不卖拿在手里，收益
        #b  交易了1次，第1次卖出后，收益
        #d  交易了1次，第1次买了后，不卖拿在手里，收益
        a=b =0
        c=d=float("-inf")   #没有开始，手上有股票，无可能性

        for p in prices:
            a = max(a,c+p)
            c = max(c,b-p)
            b = max(b,d+p)
            d = max(d,0-p)
        return a



#1th
'''
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        #because  kmax=2
        # use four Variables 
        #ai20 交易了两次，第二次卖出后，收益
        #ai21  交易了两次，第二次不卖拿在手里，收益
        #ai10  交易了1次，第1次卖出后，收益
        #ai11  交易了1次，第1次买了后，不卖拿在手里，收益
        ai20=ai10 =0
        ai21=ai11=float("-inf")   #没有开始，手上有股票，无可能性
        
        for p in prices:
            ai20 = max(ai20,ai21+p)
            ai21 = max(ai21,ai10-p)
            ai10 = max(ai10,ai11+p)
            ai11 = max(ai11,0-p)
        return ai20
        '''

