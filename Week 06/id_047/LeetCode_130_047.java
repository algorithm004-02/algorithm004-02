import java.util.Arrays;

public class LeetCode_130_047 {

    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int r = board.length;
        int c = board[0].length;

        int dummy = r * c;
        UnionFind unionFind = new UnionFind(dummy + 1);
        for (int i = 0; i < r; i ++) {
            for (int j = 0; j < c; j ++) {
                if (board[i][j] == 'O') {
                    int p = i * c + j;
                    if (i == 0 || i == r - 1 || j == 0 || j == c - 1) {
                        unionFind.union(p, dummy);
                    } else {
                        if (i - 1 >= 0 && board[i - 1][j] == 'O') {
                            unionFind.union(p, (i - 1) * c + j);
                        }

                        if (i + 1 < r && board[i + 1][j] == 'O') {
                            unionFind.union(p, (i + 1) * c + j);
                        }

                        if (j - 1 >= 0 && board[i][j - 1] == 'O') {
                            unionFind.union(p, i * c + j - 1);
                        }

                        if (j + 1 < c && board[i][j + 1] == 'O') {
                            unionFind.union(p, i * c + j + 1);
                        }
                    }
                }
            }
        }

        for (int i = 0; i < r; i ++) {
            for (int j = 0; j < c; j ++) {
                if (board[i][j] == 'O' && !unionFind.isConnect(i * c + j, dummy)) {
                    board[i][j] = 'X';
                }
            }
        }
    }


    private class UnionFind{
        int count;
        int[] parents;
        int[] rank;
        UnionFind(int count) {
            this.count = count;
            parents = new int[count];
            rank = new int[count];
            for (int i = 0; i < count; i ++) {
                parents[i] = i;
                rank[i] = 0;
            }
        }

        void union(int x,int y) {
            int parentx = find(x);
            int parenty = find(y);
            if (parentx != parenty) {
                if (rank[parentx] > rank[parenty]) {
                    parents[parenty] = parentx;
                } else if (rank[parentx] < rank[parenty]) {
                    parents[parentx] = parenty;
                } else {
                    parents[parenty] = parentx;
                    rank[parentx] ++;
                }
                count --;
            }
        }

        int find(int x) {
            while (parents[x] != x) {
                parents[x] = parents[parents[x]];
                x = parents[x];
            }
            return parents[x];
        }

        boolean isConnect(int x, int y) {
            return find(x) == find(y);
        }
    }
}

