#
# @lc app=leetcode.cn id=63 lang=python3
#
# [63] 不同路径 II
#

# @lc code=start
class Solution:
     def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        #初始化
        m = len(obstacleGrid)
        n = len(obstacleGrid[0])
        nums = [[0 for i in range(n)] for j in range(m)]
        if obstacleGrid[0][0] == 1:
            return 0
        if obstacleGrid[m - 1][n - 1] ==1:
            return 0
        else:
            nums[m - 1][n - 1] = 1
        # 最右列赋值
        for i in range(m - 2, -1, -1):
            if obstacleGrid[i][n - 1] == 1:
                nums[i][n - 1] = 0
            else:
                nums[i][n - 1] = nums [i + 1][n - 1] 
        #最下行赋值
        for j in range(n - 2, -1, -1):
            if obstacleGrid[m - 1][j] == 1:
                nums[m - 1][j] = 0
            else:
                nums[m - 1][j] = nums[m - 1][j + 1]
        
        for i in range(m - 2, -1, -1):
            for j in range(n - 2, -1, -1):
                if obstacleGrid[i][j] == 1:
                    nums[i][j] = 0
                else:
                    nums[i][j] = nums[i + 1][j] + nums[i][j + 1]
        return nums[0][0]
        
# @lc code=end

