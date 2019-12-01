class Solution {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    public void solve(char[][] board) {
        if(board == null || board.length == 0) {
            return;
        }
        int row = board.length;
        int cols = board[0].length;
        UnionFind unionFind = new UnionFind(row * cols + 1);
        int vertul = row * cols;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    if (j == 0 || j == cols - 1 || i == 0 || i == row - 1) {
                        //边界上的节点如果是O,就都和虚拟节点互相连通
                        unionFind.connect(row(i,j,cols),vertul);
                    }else {
                        //非边界的节点，就和上下左右互相连通。如果是O节点，就和周围的O互相连通
                        for (int d = 0; d < dx.length; d++) {
                            int il = i + dx[d];
                            int jl = j + dy[d];
                            if (il < 0 || il > row - 1 || jl < 0 || jl > cols - 1) {
                                //溢出节点
                                continue;
                            }
                            if(board[il][jl] == 'O') {
                                //互相连通
                                unionFind.connect(row(i,j,cols),row(il,jl,cols));
                            }
                        }
                    }
                }
            }
        }
        //再一次遍历，如果和虚拟节点不联通的O，直接赋值为X
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cols; j++) {
                if(board[i][j] == 'O' && !unionFind.isConnected(row(i,j,cols),vertul)){
                    board[i][j] = 'X';
                }
            }
        }
    }

    private int row(int i, int j, int cols) {
        return i * cols + j;
    }

    /**
     * 并查集
     * @author ;
     */
    class UnionFind {
        /**
         * 连通集的数量
         */
        private int count;
        /**
         * 某个元素的parent
         */
        private int[] parent;
        /**
         * 构造unionFind 并查集
         * @param n n是指并查集的大小
         */
        public UnionFind(int n) {
            this.count = n;
            this.parent = new int[n];
        /*
         * 刚开始，连通集的大小是固定的，i的parent就是自己。
         */
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int getCount(){
            return count;
        }

        public void connect(int p, int q) {
            int pRoot = findRoot(p);
            int qRoot = findRoot(q);
            if (qRoot == pRoot) {
                return;
            }
            parent[qRoot] = pRoot;
            count--;
        }

        private int findRoot(int p) {
            while (p  != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }
        private boolean isConnected(int node1, int node2) {
            return findRoot(node1) == findRoot(node2);
        }
    }
}