class Solution(object):
    def climbStairs(self, n):
        if n<3 : return n
        x,y=1,2
        for i in range(2,n):
            x,y=y,x+y
        return y
