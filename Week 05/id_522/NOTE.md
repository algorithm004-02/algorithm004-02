# NOTE
动态规划，老师讲的很好，就是斐波那契数列，
1、递归加上记忆化。
2、自顶向下，完事后，自底向上，在爬楼梯问题上。在二维空间，有障碍物的走法的题目上，都是。
3、定义DP  dp[状态1][状态2][...] = 择优(选择1，选择2...)
4、初始化几个值，在循环中，完善其他值。或者就是推算。

#对于动态规划题目的理解，应该在题目中看到，最大，最小，最，这个字。隐含最优子结构的意思。
#不断舍弃非最优结构，的过程，就是剪枝，大大降低工作量。

动态规划的难度，
1、随着维度的增加，由于写下标的时候，容易写错，难度增加了。在股票问题上，体现的很好。
2、定义状态，和状态转移方程，


2019-11-11 上午看了视频，下午开始刷题。

198 打家劫舍 ，还可以，没有考虑用二维数组，来处理。 当只用2个变量时，感觉很像斐波那契数列的解法。

看了一下股票的，团灭方法。
#对于动态规划题目的理解，应该在题目中看到，最大，最小，最，这个字。隐含最优子结构的意思。

团灭中说了，状态，选择，这两个词，要记住。

for 状态1 in 状态1的所有取值：
    for 状态2 in 状态2的所有取值：
        for ...
            dp[状态1][状态2][...] = 择优(选择1，选择2...)

作者：labuladong

11-12 继续

维度越多，开始需要初始化的，也越多。
对于python 由于支持负索引，所以，整体把 i 放大到 i+1 ，来避免负数索引出现。

121 题，
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if not prices :return 0
        dp=[[0,-prices[0]] for _ in range(len(prices)+1)  ]

        for i,v in enumerate(prices):
            dp[i+1][0]= max(dp[i][0] , dp[i][1]+v )
            dp[i+1][1]= max(dp[i][1],-v)
            #dp[i+1][1]= max(dp[i][1],dp[i][0]-v)
            #在k的简化中，把三维，降低为2维，但是，任何的dp[i][0][0] = 0 ，中间的k=0
            #就是没有买过股票，手里也没有股票，赚了0元。
        return dp[i+1][0]

64题，我沿着老师讲课，有障碍物那个，思路是动态规划，从下向上推。
看了国际站点，发现，从左上到右下，直接从上向下推，也是可以的；
整体代码，下标 的难度降低了。好。

##在这个题目中，我的心得是，对于二维的，一定要用x，横坐标，y 纵坐标，比i ，j 要好很多。

class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        yy=len(grid)
        if yy==1:
            return sum(grid[0])
        xx=len(grid[0])
        dp=[[0 for i in range(xx)] for j in range(yy)]
        dp[0][0]=grid[0][0]
        #初始化上边
        for y in range(1,yy): dp[y][0]=dp[y-1][0]+grid[y][0]
        #初始化左边
        for x in range(1,xx): dp[0][x]=dp[0][x-1]+grid[0][x]

        for x in range(1,xx):
            for y in range(1,yy):
                dp[y][x]=grid[y][x] +min(dp[y-1][x],dp[y][x-1])

        return dp[y][x]

####这是从右下角，向左上角推，明显看出，下标写法，难度大。--一对比就看出来了。

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
        for y in range(yy-2,-1,-1):
            dp[y][xx-1]=dp[y][xx-1]+dp[y+1][xx-1]

        #初始化下边
        for x in range(xx-2,-1,-1):
            dp[yy-1][x] =dp[yy-1][x]+dp[yy-1][x+1]

        for x in range(xx-2,-1,-1):
            for y in range(yy-2,-1,-1):
                dp[y][x]= min(dp[y+1][x],dp[y][x+1]) + dp[y][x]
        #print(dp)
        return dp[0][0]

##--------------------------------------------------------------------------------
#这是 91 题。
    def numDecodings(self, s: str) -> int:
        if not s or s[0]=='0':
            return 0

        dp = [0 for x in range(len(s) + 1)]

        # base case initialization
        dp[0:2] = [1,1]

        for i in range(2, len(s) + 1):
            # One step jump
            if 0 < int(s[i-1:i]):    #(2)
                dp[i] = dp[i - 1]
            # Two step jump
            if 10 <= int(s[i-2:i]) <= 26: #(3)
                dp[i] += dp[i - 2]     #我错在这个地方

        return dp[-1]

周四下午，把120题，70题，手撕了。

爬楼梯
class Solution(object):
    def climbStairs(self, n):
        if n<3 : return n
        x,y=1,2
        for _ in range(2,n):
            x,y=y,x+y
        return y
        


