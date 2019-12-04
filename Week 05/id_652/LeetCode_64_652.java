// 暴力解法
class Solution {
    public int minPathSum(int[][] grid) {
        return minPathSum(0, 0, grid);
    }

    private int minPathSum(int i, int j, int[][] grid) {
        if (i == grid.length || j == grid[0].length) return Integer.MAX_VALUE;
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return grid[i][j];
        }
        return grid[i][j] + Math.min(minPathSum(i+1, j, grid), minPathSum(i, j+1, grid));
    }
}

// 动态规划
class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length <= 0 || grid[0].length <= 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] states = new int[m][n];
        int sum = 0;
        for (int j = 0; j < n; j++) {
            sum += grid[0][j];
            states[0][j] = sum;
        }
        sum = 0;
        for (int i = 0;  i < m; i++) {
            sum += grid[i][0];
            states[i][0] = sum;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                states[i][j] = grid[i][j] + Math.min(states[i][j-1], states[i-1][j]);
            }
        }
        return states[m-1][n-1];
    }
}
