package src.main.java.com.fans.algorithm00402.week6.homework;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.UnknownFormatConversionException;

/**
 * 被围绕的区域
 */
public class LeetCode_130_232 {

    /**
     * 并查集
     */
    public void solve(char[][] board) {
        int n = board.length;
        if (n == 0) return;
        int m = board[0].length;
        int max = n * m;
        DisjoinSet set = new DisjoinSet(max + 1);
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                if (board[i][j] == 'O') {
                    if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                        set.union(i * m + j, max);
                    } else {
                        if (i - 1 >= 0 && board[i - 1][j] == 'O') set.union((i - 1) * m + j, i * m + j);
                        if (i + 1 < n && board[i + 1][j] == 'O') set.union((i + 1) * m + j, i * m + j);
                        if (j - 1 >= 0 && board[i][j - 1] == 'O') set.union(i * m + j - 1, i * m + j);
                        if (j + 1 < m && board[i][j + 1] == 'O') set.union(i * m + j + 1, i * m + j);
                    }
                }
            }
        }

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                if (set.isConnected(i * m + j, max)) {

                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private class DisjoinSet {
        private int size;
        private int[] parent;
        public DisjoinSet(int n) {
            size = n;
            parent = new int[n];
            for (int i = 0; i < n; i ++) {
                parent[i] = i;
            }
        }

        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
            parent[rootP] = rootQ;
            size --;
        }

        public boolean isConnected(int p, int q) {
            return find(p) == find(q);
        }
    }

    /**
     * DFS非递归
     */
//    public void solve(char[][] board) {
//        int n = board.length;
//        if (n == 0) return;
//        int m = board[0].length;
//        Stack<Integer> stack = new Stack<>();
//        int[][] dris = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
//        for (int i = 0; i < n; i ++) {
//            for (int j = 0; j < m; j ++) {
//                boolean isEdge = i == 0 || j == 0 || i == n - 1 || j == m - 1;
//                if (isEdge && board[i][j] == 'O') {
//                    board[i][j] = '#';
//                    stack.add(i * m + j);
//                    while (!stack.isEmpty()) {
//                        int index = stack.peek();
//                        int subI = index / m;
//                        int subJ = index % m;
//
//                        if (subI - 1 >= 0 && board[subI - 1][subJ] == 'O') {
//                            board[subI - 1][subJ] = '#';
//                            stack.add((subI - 1) * m + subJ);
//                            continue;
//                        }
//                        if (subI + 1 < n && board[subI + 1][subJ] == 'O') {
//                            board[subI + 1][subJ] = '#';
//                            stack.add((subI + 1) * m + subJ);
//                            continue;
//                        }
//                        if (subJ - 1 >= 0 && board[subI][subJ - 1] == 'O') {
//                            board[subI][subJ - 1] = '#';
//                            stack.add((subI) * m + subJ - 1);
//                            continue;
//                        }
//                        if (subJ + 1 < m && board[subI][subJ + 1] == 'O') {
//                            board[subI][subJ + 1] = '#';
//                            stack.add((subI) * m + subJ + 1);
//                            continue;
//                        }
//
//                        stack.pop();
//                    }
//                }
//            }
//        }
//
//        for (int i = 0; i < n; i ++) {
//            for (int j = 0; j < m; j ++) {
//                if (board[i][j] == '#') board[i][j] = 'O';
//                else if (board[i][j] == 'O') board[i][j] = 'X';
//            }
//        }
//    }

    /**
     * BFS
     */
//    public void solve(char[][] board) {
//        int n = board.length;
//        if (n == 0) return;
//        int m = board[0].length;
//        Queue<Integer> queue = new LinkedList<>();
//        int[][] dris = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
//        for (int i = 0; i < n; i ++) {
//            for (int j = 0; j < m; j ++) {
//                boolean isEdge = i == 0 || j == 0 || i == n - 1 || j == m - 1;
//                if (isEdge && board[i][j] == 'O') {
//                    board[i][j] = '#';
//                    queue.add(i * m + j);
//                    while (!queue.isEmpty()) {
//                        int index = queue.poll();
//                        int subI = index / m;
//                        int subJ = index % m;
//                        for (int[] dir : dris) {
//                            int newI = subI + dir[0];
//                            int newJ = subJ + dir[1];
//                            if (newI >= 0 && newJ >= 0 && newI < n && newJ < m && board[newI][newJ] == 'O') {
//                                board[newI][newJ] = '#';
//                                queue.add(newI * m + newJ);
//                            }
//                        }
//                    }
//                }
//            }
//        }
//
//        for (int i = 0; i < n; i ++) {
//            for (int j = 0; j < m; j ++) {
//                if (board[i][j] == '#') board[i][j] = 'O';
//                else if (board[i][j] == 'O') board[i][j] = 'X';
//            }
//        }
//    }

    /**
     * DFS
     *  - 边连通的O全部替换为#
     */
//    public void solve(char[][] board) {
//        int n = board.length;
//        if (n == 0) return;
//        int m = board[0].length;
//        for (int i = 0; i < n; i ++) {
//            for (int j = 0; j < m; j ++) {
//                boolean isEdge = i == 0 || j == 0 || i == n - 1 || j == m - 1;
//                if (isEdge && board[i][j] == 'O') {
//                    dfs(board, i, j, n, m);
//                }
//            }
//        }
//
//        for (int i = 0; i < n; i ++) {
//            for (int j = 0; j < m; j ++) {
//                if (board[i][j] == '#') board[i][j] = 'O';
//                else if (board[i][j] == 'O') board[i][j] = 'X';
//            }
//        }
//    }
//
//    private void dfs(char[][] board, int i, int j, int n, int m) {
//        if (i < 0 || i >= n || j < 0 || j >= m || board[i][j] == 'X' || board[i][j] == '#') return;
//        board[i][j] = '#';
//
//        dfs(board, i - 1, j, n, m);
//        dfs(board, i + 1, j, n, m);
//        dfs(board, i, j - 1, n, m);
//        dfs(board, i, j + 1, n, m);
//    }
//
//    public static void main(String[] args) {
//        LeetCode_130_232 code = new LeetCode_130_232();
//        char[][] chars = {{'O','X','X','O','X'},{'X','O','O','X','O'},{'X','O','X','O','X'},{'O','X','O','O','O'},{'X','X','O','X','O'}};
//        code.solve(chars);
//    }

}
