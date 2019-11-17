class Solution:
    def minimumTotal(self, triangle):
        dp=triangle
        #从下往上走
        for i in range(len(triangle)-2,-1,-1):
            for j in range(len(triangle[i])):
                dp[i][j]+=min(dp[i+1][j],dp[i+1,j+1])
        return dp[0][0]

if __name__=='__main__':
    pass