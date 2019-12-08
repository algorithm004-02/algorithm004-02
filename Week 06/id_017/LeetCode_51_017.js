

/**
 * 51.N皇后
 * @param {number} n
 * @return {string[][]}
 */
/**
 * @param {number} n
 * @return {string[][]}
 */
var solveNQueens = function(n) {
    //深度优先搜索解决N皇后问题
    let result = new Array(n);
    let results = [];
    let dfs = (row,column) => {
        let leftColumn =  column-1;
        let rightColumn = column+1;
        for(let i = row - 1;i >= 0;i--){
            if(result[i] == column){
                return false;
            }
            if(leftColumn >= 0 && result[i] == leftColumn){
                return false;
            }
            if(rightColumn < n && result[i] == rightColumn){
                return false;
            }
            leftColumn--;
            rightColumn++;
        }
        return true;
    }
    let Nqueens = (row) => {
        if(row == n){
            results.push(result.map(c=>'.'.repeat(c)+'Q'+'.'.repeat(n-1-c)));
            return;
        }
        for(let j = 0;j < n;j++){
            if(dfs(row,j)){
                result[row] = j;
                Nqueens(row+1)
            }
        }
    }
    Nqueens(0);
    return results;
};

//回溯法
// var solveNQueens = function(n) {
    
//     const res = [];
//     backtrack(res, n);
//     return res;
// };

// function backtrack(res, n, board = [], r = 0) {
//     if (r === n) {
//         res.push(board.map(c => '.'.repeat(c) + 'Q' + '.'.repeat(n - c - 1)));
//         return;
//     }
//     for (let c = 0; c < n; c++) {
//         if (!board.some((bc, br) => bc === c || bc === c + r - br || bc === c - r + br)) {
//             board.push(c);
//             backtrack(res, n, board, r + 1);
//             board.pop();
//         }
//     }
// }