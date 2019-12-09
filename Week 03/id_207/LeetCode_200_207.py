class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        # 深度优先遍历
        if not grid: return 0
        
        row = len(grid)
        col = len(grid[0])
        count = 0
        # 定义了上下左右的方向数组
        directions = [[-1, 0], [1, 0], [0, -1], [0, 1]]
        
        def dfs(i, j):
            # 把陆地替换为水，FloodFill算法
            grid[i][j] = "0"
            for x, y in directions:
                tmp_i = i + x
                tmp_j = j + y
                # 在不越界的情况下，寻找4个方向上的陆地
                if 0 <= tmp_i < row and 0 <= tmp_j < col and grid[tmp_i][tmp_j] == "1":
                    dfs(tmp_i, tmp_j)
                    
        for i in range(row):
            for j in range(col):
                if grid[i][j] == "1":
                    dfs(i, j)
                    count += 1
        return count