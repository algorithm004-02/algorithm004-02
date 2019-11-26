class Solution {
    //最小路径之和。
    public int minPathSum(int[][] grid) {
        //dp[i][j] =grid[i][j] + Math.min(dp[i-1][j],dp[i][j-1]);
        int level = grid.length;
        int wide = grid[0].length;
        for (int i = 1; i < wide; i++) {
            grid[0][i] += grid[0][i - 1];
        }
        for (int i = 1; i < level; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int i = 1; i < level; i++) {
            for (int j = 1; j < wide; j++) {
                grid[i][j] += Math.min(grid[i-1][j],grid[i][j-1]);
            }
        }
        return grid[level - 1][wide - 1];
    }
}


