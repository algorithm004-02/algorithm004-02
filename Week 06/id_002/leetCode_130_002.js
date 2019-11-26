/** 130. 被围绕的区域 */
// 1. dfs
// 2. bfs
// 3. 并查集

/**
 * 3.并查集
 * @param {character[][]} board
 * @return {void} Do not return anything, modify board in-place instead.
 */
var solve3 = function(board) {
    let m = board.length;
    if (m === 0) return board;

    let n = board[0].length;

    // 创建并查集
    let union = new UnionFind(m * n + 1);
    let dummyNode = m * n;

    for (let i = 0; i < m; i ++) {
        for (let j = 0; j < n; j++) {
            if (board[i][j] === 'X') continue;

            if (i === 0 || j === 0 || i === m - 1 || j === n - 1) {
                union.union(dummyNode, node(i, j));
                loopDir(i, j, adNode => union.union(dummyNode, adNode));
            } else {
                loopDir(i, j, adNode => union.union(node(i, j), adNode));
            }
        }
    }

    for (let i = 0; i < m; i ++) {
        for(let j = 0; j < n; j ++) {
            if (board[i][j] === 'X') continue;

            if (i === 0 || j === 0 || i === m - 1 || j === n - 1) continue; 

            if (union.isConnected(node(i, j), dummyNode)) continue;

            board[i][j] = 'X';
        }
    }

    return board;
    
    // 计算Node   
    function node(i, j) {
       return i * n + j; 
    }
    
    function loopDir(i, j, callback = adNode => {}) {
        let dir = [[1, 0], [0, 1]];
        
        dir.forEach(([x, y]) => {
            let newI = i + x;
            let newY = j + y;

            if (newI > m - 1 || newY > n - 1) return;

            if (board[newI][newY] === 'X') return;

            callback(node(newI, newY));
        });
    }
    function UnionFind(n) {
        count = n;
        parent = Array.from(Array(n), (val, k) => k);

        return {union, isConnected};

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
            let unionP = find(p);
            let unionQ = find(q);

            if (unionP === unionQ) return;
            parent[unionQ] = unionP;
            count --;
        }

        function isConnected(p, q) {
            let unionP = find(p);
            let unionQ = find(q);

            return unionP === unionQ;
        }
    }
}; 