class LeetCode_208_487 {

    /**
     * 547
     * 朋友圈
     *
     * @param grid
     * @return
     */
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0) {
            return 0;
        }
        UnionFind unionFind = new UnionFind(M.length);
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (M[i][j] == 1 && i != j) {
                    unionFind.union(i, j);
                }
            }
        }
        return unionFind.count;
    }

    class UnionFind {
        private int count = 0;
        private int[] parent;

        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int p) {
            while (p != parent[p]) {
                //压缩
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int findP = find(p);
            int findQ = find(q);
            if (findP == findQ) return;
            parent[findP] = findQ;
            count--;

        }
    }
}