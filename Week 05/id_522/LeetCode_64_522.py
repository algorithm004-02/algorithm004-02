# 64


# 第一遍
'''
class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        if not grid:return 0
        yy=len(grid)
        if yy==1:
            return sum(grid[0])
        xx=len(grid[0])

        #dp=grid
        dp=[[float("inf") for _ in range(xx+1)] for _2 in range(yy+1)]
        dp[yy-1][xx], dp[yy][xx-1]= 0,0


        for x in range(xx-1,-1,-1):
            for y in range(yy-1,-1,-1):
                dp[y][x]= min(dp[y+1][x],dp[y][x+1]) + grid[y][x]
        #print(dp)
        return dp[0][0]
'''
# 第二遍
'''
class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        if not grid:return 0

        yy=len(grid)
        if yy==1:
            return sum(grid[0])
        xx=len(grid[0])
        dp=grid
        #dp=[[0 for i in range(xx)] for j in range(yy)]
        #初始化右边
        he=0
        for y in range(yy-2,-1,-1):
            #he+=grid[y][xx-1]
            #dp[y][xx-1]=he 
            dp[y][xx-1]=grid[y][xx-1]+dp[y+1][xx-1]
            #print(dp[y][xx-1])
            
        #初始化下边    
        he=0
        for x in range(xx-1,-1,-1):
            he+=grid[yy-1][x]
            dp[yy-1][x] =he

        for x in range(xx-2,-1,-1):
            for y in range(yy-2,-1,-1):
                dp[y][x]= min(dp[y+1][x],dp[y][x+1]) + grid[y][x]
        #print(dp)
        return dp[0][0]
'''

# 第三遍   95.47%
'''


class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        if not grid: return 0

        yy = len(grid)
        if yy == 1:
            return sum(grid[0])
        xx = len(grid[0])
        dp = grid
        # dp=[[0 for i in range(xx)] for j in range(yy)]
        # 初始化右边
        for y in range(yy - 2, -1, -1):
            dp[y][xx - 1] = grid[y][xx - 1] + dp[y + 1][xx - 1]

        # 初始化下边
        for x in range(xx - 2, -1, -1):
            dp[yy - 1][x] = grid[yy - 1][x] + dp[yy - 1][x + 1]

        for x in range(xx - 2, -1, -1):
            for y in range(yy - 2, -1, -1):
                dp[y][x] = min(dp[y + 1][x], dp[y][x + 1]) + grid[y][x]
        # print(dp)
        return dp[0][0]
'''

# 4th

'''
class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        if not grid:return 0

        yy=len(grid)
        if yy==1:
            return sum(grid[0])
        xx=len(grid[0])

        dp=[[0 for i in range(xx)] for j in range(yy)]
        #初始化右边
        he=0
        for y in range(yy-1,-1,-1):
            he+=grid[y][xx-1]
            dp[y][xx-1]=he
            #print(dp[y][xx-1])
            
        #初始化下边    
        he=0
        for x in range(xx-1,-1,-1):
            he+=grid[yy-1][x]
            dp[yy-1][x] =he

        for x in range(xx-2,-1,-1):
            for y in range(yy-2,-1,-1):
                dp[y][x]= min(dp[y+1][x],dp[y][x+1]) + grid[y][x]
        #print(dp)
        return dp[0][0]
'''


# 5th  98.48     112ms


class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        if not grid: return 0

        yy = len(grid)
        if yy == 1:
            return sum(grid[0])
        xx = len(grid[0])
        dp = grid
        # dp=[[0 for i in range(xx)] for j in range(yy)]
        # 初始化右边
        for y in range(yy - 2, -1, -1):
            dp[y][xx - 1] = dp[y][xx - 1] + dp[y + 1][xx - 1]

        # 初始化下边
        for x in range(xx - 2, -1, -1):
            dp[yy - 1][x] = dp[yy - 1][x] + dp[yy - 1][x + 1]

        for x in range(xx - 2, -1, -1):
            for y in range(yy - 2, -1, -1):
                dp[y][x] = min(dp[y + 1][x], dp[y][x + 1]) + grid[y][x]
        # print(dp)
        return dp[0][0]
