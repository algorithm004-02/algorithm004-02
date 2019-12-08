/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start
class Solution {

    static class UnionFind {
        int count;
        int[] parent;

        public UnionFind(char[][] grid) {
            int rowLen = grid.length;
            int colLen = grid[0].length;
            parent = new int[rowLen * colLen];
            count = 0;
            for (int i = 0; i < rowLen; i++) {
                for (int j = 0; j < colLen; j++) {
                    if (grid[i][j] == '1') {
                        parent[i * colLen + j] = i * colLen + j;
                        count++;
                    }
                }
            }
        }

        public int find(int i) {
            if (i != parent[i])
                parent[i] = find(parent[i]);
            return parent[i];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootX] = rootY;
                --count;
            }
        }
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    int old = i * col + j;

                    if (j > 0 && grid[i][j - 1] == '1') {
                        uf.union(old, old - 1);
                    }
                    if (j < col - 1 && grid[i][j + 1] == '1') {
                        uf.union(old, old + 1);
                    }
                    if (i > 0 && grid[i - 1][j] == '1') {
                        uf.union(old, old - col);
                    }
                    if (i < row - 1 && grid[i + 1][j] == '1') {
                        uf.union(old, old + col);
                    }
                }
            }
        }
        return uf.count;
    }
}
// @lc code=end
