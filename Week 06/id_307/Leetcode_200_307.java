class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                count += sinkByDfs(grid, j, i);
            }
        }
        return count;
    }

    private static final int[] dx = new int[] {-1, 1, 0, 0};
    private static final int[] dy = new int[] {0, 0, -1, 1};

    public int sinkByDfs(char[][] grid, int x, int y) {
        if (grid[y][x] == '0') {
            return 0;
        }
        grid[y][x] = '0';
        int tx, ty;
        for (int i = 0; i < dx.length; i++) {
            tx = x + dx[i];
            ty = y + dy[i];
            if (ty > -1 && ty < grid.length && tx > -1 && tx < grid[0].length && grid[ty][tx] == '1') {
                sinkByDfs(grid, tx, ty);
            }
        }
        return 1;
    }
}