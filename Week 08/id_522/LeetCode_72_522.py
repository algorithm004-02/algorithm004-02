class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        yy ,xx =len(word1),len(word2)
        s="#"+word1
        t="#"+word2
        dp=[[0] *(xx+1) for _ in range(yy+1)]
        for x in range(xx+1):dp[0][x]=x
        for y in range(yy+1):dp[y][0]=y

        for y in range(1,yy+1):
            for x in range(1,xx+1):
                if s[y] == t[x]:
                    dp[y][x]=dp[y-1][x-1]
                else:
                    dp[y][x]=1+min(dp[y-1][x-1],dp[y-1][x],dp[y][x-1])
        return dp[-1][-1]

'''
这个题目的难度，主要是y x ，代表的意思，竟然是两个字符串的下标。这个状态定义很难。

'''
