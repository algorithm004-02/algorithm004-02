/** 200. 岛屿数量 **/
// 1. DFS 
// 2. BFS
// 3. 并查集

/**
 * test [["1"]], [["0"]] m * n + 1
 * @param {character[][]} grid
 * @return {number}
 */
var numIslands = function(grid) {
    let m = grid.length;
    if (m === 0) return 0; 
    
    let n = grid[0].length;
    
    // 构建并查集 把为零群里放入一群里 所以加一
    let union = new UnionFind(m * n + 1);
    
    // 方向向量  往x,y方向推进
    let dir = [[1, 0], [0, 1]];

    // 零集合根节点
    let dummyNode = m * n;

    // 遍历表格
    for(let i = 0; i < grid.length; i ++) {
        for (let j = 0; j < grid[i].length; j ++) {
            let node = getNode(i, j);
            if (grid[i][j] === "0") {
                unionDummy(node);
                continue;
            }

            dir.forEach(([x, y]) => {
                let newI = i + x;
                let newJ = j + y;
                if (newI >= m || newJ >= n) return;

                grid[newI][newJ] === '1' ? union.union(node, getNode(newI, newJ)) : unionDummy(getNode(newI, newJ));
            });
        }
    }
    
    let count = union.getCount() - 1;
    return count;
    
    // 根据i,j 获取 Node
    function getNode(i, j) {
        return i * n + j;
    }

    // 添加0集合
    function unionDummy(node) {
        union.union(dummyNode, node); 
    }

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