class Solution {

    void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        // 终止条件：超出边界或当前点为海洋，无需再爆破该点及周边的点
        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }

        // 爆破当前点
        grid[r][c] = '0';
        // 左边
        dfs(grid, r - 1, c);
        // 右边
        dfs(grid, r + 1, c);
        // 下边
        dfs(grid, r, c - 1);
        // 上边
        dfs(grid, r, c + 1);
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        // 遍历地图
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {

                if (grid[r][c] == '1') {
                    // 如果当前点为陆地，记录陆地个数，并爆破相邻陆地
                    ++num_islands;
                    dfs(grid, r, c);
                }
            }
        }

        return num_islands;
    }
}