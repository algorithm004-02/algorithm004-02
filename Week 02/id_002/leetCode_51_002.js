/*** 51. N皇后 ***/
/**
 * 递归分治、回溯
 * @param {number} n
 * @return {string[][]}
 */
var solveNQueens = function(n) {
    let result = [];
    let cols = new Set();
    let pie = new Set();
    let na = new Set();
    
    DFS(0, []);
    return generateResult(result);
    function DFS(row, curState = []) {
        if(row >= n) return result.push([...curState]);
        
        for(let col = 0; col < n; col++) {
            if(cols.has(col) || pie.has(row + col) || na.has(row - col)) continue;
            
            cols.add(col);
            pie.add(row + col);
            na.add(row - col);
            
            DFS(row + 1, [...curState, col]);
            
            cols.delete(col);
            pie.delete(row + col);
            na.delete(row - col);
        }
    }
    function generateResult(result) {
        return result.map(ite => ite.map(c => "Q".padStart(c + 1, '.').padEnd(n, '.')));
    }
};