class Solution {
    public int findCircleNum(int[][] M) {
        DisjoinSet set = new DisjoinSet(M.length);
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (M[i][j] == 1) {
                    set.union(i, j);
                }
            }
        }
        return set.count();
    }
    class DisjoinSet {
        private int count;
        private int[] parent;

        DisjoinSet(int count) {
            this.count = count;
            parent = new int[count];
            for (int i = 0; i < count; i++) {
                parent[i] = i;
            }
        }

        int find(int agent) {
            while (agent != parent[agent]) {
                parent[agent] = parent[parent[agent]];
                agent = parent[agent];
            }
            return agent;
        }

        void union(int a, int b) {
            int aAgent = find(a);
            int bAgent = find(b);
            if (aAgent != bAgent) {
                parent[aAgent] = bAgent;
                this.count--;
            }
        }

        int count() {
            return this.count;
        }
        
    }
}