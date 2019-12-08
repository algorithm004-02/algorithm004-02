package datastruct.unionFind;

/**
 * 并查集代码模板
 */
public class UnionFind {

    private int count = 0;
    private int[] parent,rank;

    public UnionFind(int n) {
        count = n;
        parent = new int[n];
        rank = new int[n];
        for (int i = 0;i < n;i++) {
            parent[i] = i;
        }
    }

    public int find(int p) {
        // 查找最终的父节点
        while (p != parent[p]) {
            //当前查找结点不等于父节点时候，往上查找
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public void union(int p,int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        if (rank[rootQ] > rank[rootP]) {
            parent[rootP] = rootQ;
        }
        else {
            parent[rootQ] = rootP;
            if (rank[rootP] == rank[rootQ]) {
                rank[rootP] ++;
            }
        }
        count --;
    }

    public int count() {
        return count;
    }
}
