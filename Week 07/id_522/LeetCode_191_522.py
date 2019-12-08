class Solution(object):
    def hammingWeight(self,n):return bin(n).count("1")

'''  change some code 
class Solution(object):
    def hammingWeight(self,n):
        a=0
        while n>0:
            n=n&(n-1)
            a+=1
        return a
'''
