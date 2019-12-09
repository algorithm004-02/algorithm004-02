/** 36. 有效的数独 **/

/**
 * @param {character[][]} board
 * @return {boolean}
 */
var isValidSudoku = function(board) {
    let n = board.length;
    let colSets = [];
    let rowSets = [];
    let gridSets = [];

    for (let i = 0; i < 9; i ++) {
        colSets[i] = new Set();
        rowSets[i] = new Set();
        gridSets[i] = new Set();
    }
    
    for (let i = 0; i < n; i ++) {
        for (let j = 0; j < n; j ++) {
            let number = board[i][j];
            if (number === '.') continue;

            let index = (i / 3 | 0) * 3  + (j / 3 | 0); 

            let rowSet = rowSets[i];
            let colSet = colSets[j];
            let gridSet = gridSets[index];
            
            if (rowSet.has(number) || colSet.has(number) || gridSet.has(number)) return false;
            
            rowSet.add(number);
            colSet.add(number);
            gridSet.add(number);
        }
    }

    return true;
};