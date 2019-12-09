class Solution(object):
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        # i-1 
        # i-2
        dp = dict()
        
        dp[1] = 1
        dp[2] = 2
        
        
        i = 3
        while i <= n:
            dp[i] = dp[i-1] + dp[i-2]
            i += 1
            
        return dp[n]