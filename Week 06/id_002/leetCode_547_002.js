/** 547. 朋友圈  **/

// 1. dfs
// 2. bfs
// 3. 并查集

/**
 * 并查集
 * @param {number[][]} M
 * @return {number}
 */
var findCircleNum = function(M) {
    // 初始化并查集
    let len = M.length;
    let union = new UnionFind(len);

   
    for(let i = 0; i < len; i ++) {
        for(let j = 0; j < len; j++) {
            // 找关系
            if (M[i][j] === 1) {
                union.union(i, j);
            }
        }
    }

    return union.getCount();

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
};