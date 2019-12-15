package src.main.java.com.fans.algorithm00402.week6.homework;

import java.security.PublicKey;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 岛屿数量
 */
public class LeetCode_200_232 {

    public static void main(String[] args) {
        LeetCode_200_232 code = new LeetCode_200_232();
        char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        code.numIslands(grid);
    }

    // 并查集
    public int numIslands(char[][] grid) {
        int n = grid.length;
        if (n == 0) return 0;
        int m = grid[0].length;
        DisjoinSet set = new DisjoinSet(n * m + 1);
        for (int i = 0; i < n - 1; i ++) {
            for (int j = 0;j < m - 1; j ++) {
                if (grid[i][j] == '0')
                    set.union(i * m + j, n * m);
                if (grid[i][j] == '1') {
                    int newX = i + 1;
                    int newY = j + 1;
                    if (newX < n && grid[newX][j] == '1')
                        set.union(i * m + j, newX * m + j );
                    if (newY < m && grid[i][newY] == '1')
                        set.union(i * m + j, i * m + newY);
                }
            }
        }
        return set.size - 1;
    }

    class DisjoinSet {
        private int size = 0;
        private int[] parents;
        public DisjoinSet(int n) {
            size = n;
            parents = new int[n];
            for (int i = 0; i < n; i ++) {
                parents[i] = i;
            }
        }

        public int find(int p) {
            while (p != parents[p]) {
                parents[p] = parents[parents[p]];
                p = parents[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
            parents[rootQ] = rootP;
            size --;
        }
    }

    // bfs
//    public int numIslands(char[][] grid) {
//        int count = 0;
//        int n = grid.length;
//        if (n == 0) return 0;
//        int m = grid[0].length;
//        Queue<Integer> queue = new LinkedList<>();
//        for (int i = 0; i < n; i ++) {
//            for (int j = 0; j < m; j ++) {
//                if (grid[i][j] == '1') {
//                    queue.add(i * m + j);
//                    grid[i][j] = '0';
//                    while (!queue.isEmpty()) {
//                        int index = queue.poll();
//                        int subI = index / m;
//                        int subJ = index % m;
//                        if (subI - 1 >= 0 && grid[subI - 1][subJ] == '1') {
//                            queue.add((subI - 1) * m + subJ);
//                            grid[subI - 1][subJ] = '0';
//                        }
//                        if (subI + 1 < n && grid[subI + 1][subJ] == '1') {
//                            queue.add((subI + 1) * m + subJ);
//                            grid[subI + 1][subJ] = '0';
//                        }
//                        if (subJ - 1 >= 0 && grid[subI][subJ - 1] == '1') {
//                            queue.add((subI) * m + subJ - 1);
//                            grid[subI][subJ - 1] = '0';
//                        }
//                        if (subJ + 1 < m && grid[subI][subJ + 1] == '1') {
//                            queue.add((subI) * m + subJ + 1);
//                            grid[subI][subJ + 1] = '0';
//                        }
//                    }
//                    count ++;
//                }
//            }
//        }
//        return count;
//    }


    // dfs
//     public int numIslands(char[][] grid) {
//         int count = 0;
//         int n = grid.length;
//         if (n == 0) return 0;
//         int m = grid[0].length;
//         for (int i = 0; i < n; i ++) {
//             for (int j = 0; j < m; j ++) {
//                 if (grid[i][j] == '1') {
//                     dfs(grid, i, j, n, m);
//                     count ++;
//                 }
//             }
//         }
//         return count;
//     }

//     private void dfs(char[][] grid, int i, int j, int n, int m) {
//         if (i < 0 ||j < 0 || i >= n ||j >= m || grid[i][j] == '0') return;

//         grid[i][j] = '0';
//         dfs(grid, i - 1, j, n, m);
//         dfs(grid, i + 1, j, n, m);
//         dfs(grid, i, j - 1, n, m);
//         dfs(grid, i, j + 1, n, m);
//     }
}
