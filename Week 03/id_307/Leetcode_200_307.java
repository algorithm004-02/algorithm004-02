class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }
                islands += sink(grid, j, i);
            }
        }
        return islands;
    }
    private static final int[] dy = {1, -1};
    private static final int[] dx = {1, -1};
    public int sink(char[][] grid, int x, int y) {
        if (grid[y][x] == '0') {
            return 0;
        }
        // grid[y][x] ==> '1'
        grid[y][x] = '0';
        for (int i = 0; i < dy.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx > -1 && nx < grid[y].length) {
                sink(grid, nx, y);
            }
            if (ny > -1 && ny < grid.length) {
                sink(grid, x, ny);
            }
        }
        return 1;
    }
}