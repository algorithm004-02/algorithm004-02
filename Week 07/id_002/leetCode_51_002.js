
/** 51. N皇后 **/

/**
 * N皇后 位运算 终极解法
 * @param {number} n
 * @return {string[][]}
 */
var solveNQueens = function(n) {
    let result = [];
    let count = 0;
    
    DFS(0, 0, 0, 0);
    return result.map(generater);
    
    function DFS(row, cols, pie, na, curState = []) {
        if (row >= n) {
            count ++;
            result.push(curState);
            return;
        }

        let bits = (~(cols | pie | na) & ((1 << n) - 1));
        
        while(bits) {
            let p = bits & (-bits); //取末尾1 
            bits &= (bits - 1);
            DFS(row + 1, (cols | p) , (pie | p) << 1, (na | p) >> 1, [...curState, p]); 
        }
    }
    
    function generater(g) {
        let str = '.'.repeat(n);
        return g.map(p => {
            let arr = str.split('');
            arr[Math.log2(p)] = 'Q';
            return arr.join('');
        });
    }
    /*
    function generater(g) {
        return g.map(p => {
            // 把p中1变为0 1111 ^ 0010 => 11101 翻转 10111
            let bit = (((1 << n) - 1) ^ p);
            let str = bit.toString(2).padStart(n, '0');
            return str.split('').map(s => s === '1' ? '.' : 'Q').reverse().join('');
        });
    }*/
};