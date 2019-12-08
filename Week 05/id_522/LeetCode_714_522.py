#中等难度，直接手撕

#4th
'''执行用时 :
748 ms, 在所有 python3 提交中击败了100.00%的用户
内存消耗 :20.7 MB, 在所有 python3 提交中击败了6.45%的用户

贯彻，
能用常量，不用变量，
能不调用函数，就不调用。  但是注释要多写
'''
class Solution:
    def maxProfit(self,p,f): #f =fee  p is list
        b,s =-99999,0  #b=buy s=sell
        for i in p:
            t=b
            if b<s-i-f:
                b=s-i-f
            if s<t+i:
                s=t+i
            #s=max(s,t+i)
        return s
#-----------------------------------------------------
#3th  执行用时 :760 ms, 在所有 python3 提交中击败了98.86%的用户
'''
class Solution:
    def maxProfit(self, p, f) -> int:
        b,s =-99999,0  #b=buy s=sell
        for i in p:
            t=b
            if b<s-i-f:b=s-i-f
            if s<t+i:s=t+i
            #s=max(s,t+i)
        return s
'''
#1th
'''
class Solution:
    def maxProfit(self,p, fee):
        a1,a0=float("-inf"),0
        for i in p:
            t=a1
            a1=max(a1,a0-i-fee)
            a0=max(a0,t+i)
        return a0
#2th
class Solution:
    def maxProfit(self, p: List[int], fee: int) -> int:
        a,b =-99999,0
        for i in p:
            b,a=max(b,a+i),max(a,b-i-fee)
        return b
'''
