
/** 52. N皇后 II **/

/**
 * @param {number} n
 * @return {number}
 */
var totalNQueens = function(n) {
    let count = 0;
    DFS(0, 0, 0);
    return
    function DFS(row, cols, pie, na) {
        if (row >= n) {
            return count ++;
        }
        
        let bits = (~(cols | pie | na) & ((1 << n) - 1));

        while(bits) {
            let p = bits & -bits;
            bits &= (bits - 1);   
            bits >> 1;
            
            DFS(row + 1, cols | p,  (pie | p) << 1, (na | p) >> 1);
        }
    }
};