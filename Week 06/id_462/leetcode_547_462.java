class Solution {
    public int findCircleNum(int[][] M) {
        int n = M.length;
        UnionFind unionFind = new UnionFind(n);
        for (int i = 0;i < n; i++) {
            for (int j = 0; j < M[0].length; j++) {
                if (M[i][j] == 1) {
                    unionFind.connect(i, j);
                }
            }
        }
        return unionFind.getCount();
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
    }
}