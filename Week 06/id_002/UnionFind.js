 // 实现一个并查集
 function UnionFind(n) {
    let count = n;
    let parent = Array.from(Array(n), (v, k) => k);
    return {getCount, find, union};

    function getCount() {
        return count;
    }

    function find(p) {
        while(p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }

        return p;
    }
    function union(p, q) {
        let rootP = find(p);
        let rootQ = find(q);
        if (rootP === rootQ) return;

        parent[rootQ] = rootP;

        count --;
    }
}   