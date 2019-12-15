/** 51. N皇后 **/

/**
 * 分治 + 回溯
 * @param {number} n
 * @return {string[][]}
 */
var solveNQueens = function(n) {
    let res = [];
    let cols = new Set();
    let pies = new Set();
    let nas = new Set();

    dfs(0);
    
    return res.map(r => r.map(col => "Q".padStart(col + 1, '.').padEnd(n, '.')));
    
    function dfs(row, cur = []) {
        if (row >= n) return res.push([...cur]);

        for (let col = 0; col < n; col ++) {
            if (cols.has(col) || pies.has(row + col) || nas.has(col - row)) continue;
            
            cols.add(col);
            pies.add(row + col);
            nas.add(col - row);

            dfs(row + 1, [...cur, col]);
            
            cols.delete(col);
            pies.delete(row + col);
            nas.delete(col - row);
        }
    }
};
