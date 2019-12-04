public class LeetCode_200_047 {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        UnionFind unionFind = new UnionFind(grid);
        int r = grid.length;
        int c = grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';//why?
                    if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                        unionFind.union((i - 1) * c + j, i * c + j);
                    }
                    if (i + 1 < grid.length && grid[i + 1][j] == '1') {
                        unionFind.union((i + 1) * c + j, i * c + j);
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                        unionFind.union(i * c + j - 1, i * c + j);
                    }
                    if (j + 1 < c && grid[i][j + 1] == '1') {
                        unionFind.union(i * c + j + 1, i * c + j);
                    }
                }
            }
        }
        return unionFind.count;
    }

    private class UnionFind {

        int count;
        int[] parent;
        int[] rank;

        public UnionFind(char[][] grid) {
            int r = grid.length;
            int c = grid[0].length;
            parent = new int[r * c];
            rank = new int[r * c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (grid[i][j] == '1') {
                        count++;
                        parent[c * i + j] = c * i + j;
                    }
                    rank[c * i + j] = 0;
                }
            }
        }

        public void union(int x, int y) {
            int rootx = find(x);
            int rooty = find(y);
            if (rootx != rooty) {
                if (rank[rootx] > rank[rooty]) {
                    parent[rooty] = rootx;
                } else if (rank[rootx] < rank[rooty]) {
                    parent[rootx] = rooty;
                } else {
                    parent[rooty] = rootx;
                    rank[rootx]++;
                }
                count--;
            }
        }

        public int find(int p) {
            if (parent[p] != p) {
                parent[p] = find(parent[p]);
            }
            return parent[p];
        }
    }

}

