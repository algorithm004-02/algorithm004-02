
# dp  搞错了 ,我倒数第二行，搞错了，

class Solution:
    def numDecodings(self, s: str) -> int:
        if not s or s[0]=='0':
            return 0

        dp = [0 for x in range(len(s) + 1)]

        # base case initialization
        dp[0:2] = [1,1]
        #dp[0]=1
        #dp[1]=1

        for i in range(2, len(s) + 1):
            # One step jump
            if 0 < int(s[i-1]):    #(2)  example: "2008"
                dp[i] = dp[i - 1]
            # Two step jump
            if 10 <= int(s[i-2:i]) <= 26: #(3)
                dp[i] += dp[i - 2]   # the  most useful point
                #dp[i] +=1   error
        return dp[-1]
