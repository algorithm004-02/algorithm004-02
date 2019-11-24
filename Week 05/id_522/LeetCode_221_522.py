# dp 由于涉及了字符串转整数，我们新开一个dp 二维的。修改了几次，看了国际站


#5th

'''

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        m=matrix
        for y in range(len(m)):
            for x in range(len(m[y])):
                m[y][x]=int(m[y][x])
                if m[y][x] and y and x:
                    m[y][x]=1 + min(m[y-1][x],m[y][x-1],m[y-1][x-1])
        return len(m) and max(map(max,m))**2
#               The expression x and y     ----first evaluates x; if x is false, its value is returned; otherwise, y is evaluated and the resulting value is returned.
'''


'''
Runtime: 188 ms, faster than 98.96% of Python3 online submissions for Maximal Square.
Memory Usage: 13.7 MB, less than 100.00% of Python3 online submissions for Maximal Square.

'''




# 4th
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if not matrix: return 0
        yy = len(matrix)
        xx = len(matrix[0])
        dp = [[0] * xx for _ in range(yy)]  # 初始化

        for y in range(0, yy):
            for x in range(0, xx):
                if x * y == 0:
                    dp[y][x] = int(matrix[y][x]) # 初始化
                elif matrix[y][x] == "1":
                    dp[y][x] = min(dp[y - 1][x], dp[y - 1][x - 1], dp[y][x - 1]) + 1

        return max(map(max, dp)) ** 2


# 3th
'''
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if not matrix: return 0
        yy = len(matrix)
        # if yy==1:
        #  if max(matrix[0]==1):return 1
        # return 0
        xx = len(matrix[0])
        dp = [[0] * xx for _ in range(yy)]  # 初始化

        for y in range(0, yy):
            for x in range(0, xx):
                if x * y == 0:
                    dp[y][x] = int(matrix[y][x])  # 初始化左边 和最上边

                elif matrix[y][x] == "1" :
                    dp[y][x] = min(dp[y - 1][x], dp[y - 1][x - 1], dp[y][x - 1]) + 1
                    # else:
                    # dp[y][x]=0   #no need
        # print(dp)
        # print(map(max,dp))
        # for k in map(max,dp): print(k)
        return max(map(max, dp)) ** 2  # learn from  光头哥




#2th

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if not matrix: return 0
        yy = len(matrix)
        # if yy==1:
        #  if max(matrix[0]==1):return 1
        # return 0
        xx = len(matrix[0])
        dp = [[0] * xx for _ in range(yy)]  # 初始化

        for y in range(0, yy):
            for x in range(0, xx):
                if x * y == 0:
                    dp[y][x] = int(matrix[y][x])  # 初始化左边 和最上边

                if matrix[y][x] == "1" and x and y:
                    dp[y][x] = min(dp[y - 1][x], dp[y - 1][x - 1], dp[y][x - 1]) + 1
                else:
                    dp[y][x]=0   
        # print(dp)
        # print(map(max,dp))
        # for k in map(max,dp): print(k)
        return max(map(max, dp)) ** 2  # learn from  光头哥
'''

# 1th
'''
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if not matrix: return 0
        yy = len(matrix)
        if yy == 1:
            for i in matrix[0]:
                if i == "1": return 1
            return 0
        xx = len(matrix[0])
        dp = [[0] * xx for _ in range(yy)]  # 初始化
        big = 0
        for y in range(0, yy):
            for x in range(0, xx):
                if x * y == 0:
                    dp[y][x] = int(matrix[y][x])  # 初始化左边 和最上边
                    if dp[y][x] == 1:
                        big = max(big, dp[y][x])  # 避免变小，避免[[0,1],[1,0]]
                if x and y:
                    if matrix[y][x] == "1":
                        dp[y][x] = min(dp[y - 1][x], dp[y - 1][x - 1], dp[y][x - 1]) + 1
                        if big < dp[y][x]:
                            big = dp[y][x]
        return big * big
'''
