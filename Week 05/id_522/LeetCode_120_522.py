#直接手撕

#1th
'''
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        if not triangle :return 0

        yy=len(triangle)
        #xx=len(triangle[-1])
        dp=triangle[-1]
        #print(dp)
        for y in range(yy-2,-1,-1):
            for x in range(0,y+1):  # from left to right

                dp[x]= min(dp[x],  dp[x+1] )+triangle[y][x]
        #print(dp)
        return dp[0]

#2th

class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        #if not triangle :return 0
        yy=len(triangle)
        dp=triangle[-1]
        for y in range(yy-2,-1,-1): 
            for x in range(0,y+1):  # from left to right
                dp[x]= min(dp[x],  dp[x+1] )+triangle[y][x]
        #print(dp)
        return dp[0]


'''
#3th   72 ms  。
class Solution:
    def minimumTotal(self, t):
        yy= len(t)
        dp= t[-1]
        for y in range(yy-2,-1,-1):
            for x in range(0,y+1):  # from left to right
                dp[x]=min(dp[x],dp[x+1]) + t[y][x]
        return dp[0]

''' 国际站点
class Solution:
    def minimumTotal(self, triangle):
        if not triangle:
            return          #测试了，可以删除。
        res = triangle[-1]
        for i in range(len(triangle)-2, -1, -1):
            for j in range(len(triangle[i])):
                res[j] = min(res[j], res[j+1]) + triangle[i][j]
        return res[0]
        '''
