#
# @lc app=leetcode.cn id=200 lang=python3
#
# [200] 岛屿数量
#

# @lc code=start
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if grid:
            nr = len(grid)
            nc = len(grid[0])
        else:
            return 0

        def dfs(grid, r, c):  
            grid[r][c] = '0' 
            #print('grid[{0}][{1}]'.format(r, c))         
            if r - 1 >=0 and grid[r - 1][c] == '1':
                dfs(grid, r-1, c)
            if r + 1 < nr and grid[r + 1][c] == '1':
                dfs(grid, r+1, c)
            if c - 1 >=0 and grid[r][c - 1] == '1':
                dfs(grid, r, c - 1)
            if c + 1 < nc and grid[r][c + 1] == '1':
                dfs(grid, r, c + 1)    
        
        countIland = 0
        #print('nr={0},nc={1}'.format(nr,nc))
        for i in range(0, nr):
            for j in range(0, nc):
                #print('grid[{0}][{1}]={2}'.format( i, j, grid[i][j])) 
                if grid[i][j] == '1':
                    countIland += 1
                    dfs(grid, i, j)
                    
        return countIland
#测试发现1是字符 
#没有考虑极端情况，[]做容错     
# @lc code=end

