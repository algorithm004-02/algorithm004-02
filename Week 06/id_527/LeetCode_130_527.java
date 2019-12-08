/*
 * @lc app=leetcode.cn id=130 lang=java
 *
 * [130] 被围绕的区域
 */

// @lc code=start
class Solution {

    static class UnionFind {
        int[] parent;

        public UnionFind(int len) {
            parent = new int[len];
            for (int i = 0; i < len; i++) {
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
            int pSet = find(p);
            int qSet = find(q);
            if (pSet != qSet) {
                parent[qSet] = pSet;
            }
        }

        public boolean isConnect(int p, int q) {
            return find(p) == find(q);
        }
    }

    public void solve(char[][] board) {
        if (board == null || board.length < 3 || board[0].length < 3) {
            return;
        }
        int row = board.length;
        int col = board[0].length;
        int dummyNode = row * col;

        UnionFind uf = new UnionFind(dummyNode + 1);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    int old = i * col + j;
                    if (i == 0 || j == 0 || i == row - 1 || j == col - 1) {
                        uf.union(old, dummyNode);
                    }
                    if (j > 0 && board[i][j - 1] == 'O') {
                        uf.union(old, old - 1);
                    }
                    if (j < col - 1 && board[i][j + 1] == 'O') {
                        uf.union(old, old + 1);
                    }
                    if (i > 0 && board[i - 1][j] == 'O') {
                        uf.union(old, old - col);
                    }
                    if (i < row - 1 && board[i + 1][j] == 'O') {
                        uf.union(old, old + col);
                    }
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int old = i * col + j;
                if (!uf.isConnect(old, dummyNode)) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}

// @lc code=end
