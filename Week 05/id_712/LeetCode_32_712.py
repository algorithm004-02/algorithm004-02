class Solution:
    def longestValidParentheses(self,s):
        dp=[0]*len(s)
        max_to_now = 0
        for i in range(1,len(s)):
            if s[i]==')':
                if s[i-1]=='(':
                    dp[i]=dp[i-2]+2
                elif i-dp[i-1]-1>0 and s[i-dp[i-1]-1]=='(':
                    if dp[i-1]>0:
                        dp[i]=dp[i-1]+2+dp[i-dp[i-1]-2]
                    else:
                        dp[i]=0
                max_to_now=max(max_to_now,dp[i])
        return max_to_now
