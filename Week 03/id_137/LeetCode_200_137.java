public class LeetCode_200_137 {
    public int numIslands(char[][] grid) {
        int sum = 0;
        for (int i = 0, xLength = grid.length - 1; i <= xLength; i++) {
            for (int j = 0, yLength = grid[i].length - 1; j <= yLength; j++) {
                if (grid[i][j] == '1') {
                    sum++;
                    dfs(grid, i, j, xLength, yLength);
                }
            }
        }
        return sum;
    }

    private void dfs(char[][] grid, int x, int y, int xLength, int yLength) {
        if (x < 0 || x > xLength || y < 0 || y > yLength || grid[x][y] == '0') return;
        grid[x][y] = '0';
        dfs(grid, x - 1, y, xLength, yLength);
        dfs(grid, x + 1, y, xLength, yLength);
        dfs(grid, x, y - 1, xLength, yLength);
        dfs(grid, x, y + 1, xLength, yLength);
    }
}
