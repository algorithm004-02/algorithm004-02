//DFS
class Solution1 {
    int[] dx = {0, 0, -1, 1}; // 上下左右
    int[] dy = {-1, 1, 0, 0}; // 上下左右
    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        boolean[][] visit = new boolean[grid.length][grid[0].length];
        int ret = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visit[i][j] && grid[i][j] == '1') {
                    dfs(grid, visit, i, j);
                    ret += 1;
                }
            }
        }
        return ret;
    }

    // 深度优先搜索
    public void dfs(char[][] grid, boolean[][] visit, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return;
        }
        if (!visit[x][y] && grid[x][y] == '1') {
            visit[x][y] = true;
            for (int i = 0; i < 4; i++) {
                dfs(grid, visit, x + dx[i], y + dy[i]);
            }
        }
    }
}

//BFS
class Solution2 {
    int[] dx = {0, 0, -1, 1}; // 上下左右
    int[] dy = {-1, 1, 0, 0}; // 上下左右
    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        boolean[][] visit = new boolean[grid.length][grid[0].length];
        int ret = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visit[i][j] && grid[i][j] == '1') {
                    bfs(grid, visit, i, j);
                    ret += 1;
                }
            }
        }
        return ret;
    }

    // 广度优先搜索
    public void bfs(char[][] grid, boolean[][] visit, int x, int y) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(x, y));
        visit[x][y] = true;
        while (!queue.isEmpty()) {
            Pair top = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newX = top.x + dx[i];
                int newY = top.y + dy[i];
                if (newX < 0 || newX >= grid.length || newY < 0 || newY >= grid[0].length) {
                    continue;
                }
                if (!visit[newX][newY] && grid[newX][newY] == '1') {
                    queue.offer(new Pair(newX, newY));
                    visit[newX][newY] = true;
                }
            }
        }
    }

    static class Pair {
        int x;
        int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}