
#714

class Solution:
    def maxProfit(self,p,f):
        b,s =-99999,0  #b=buy s=sell
        for i in p:
            t=b
            if b<s-i-f:
                b=s-i-f
            if s<t+i:
                s=t+i
            #s=max(s,t+i)
        return s
