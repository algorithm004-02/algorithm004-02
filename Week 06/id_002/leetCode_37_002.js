/** 37. 解数独 */
/**
 * 自己实现版本 未优化
 * @param {character[][]} board
 * @return {void} Do not return anything, modify board in-place instead.
 */
var solveSudoku = function(board) {
    let rowSets = [];
    let colSets = [];
    let gridSets = [];
    
    let n = board.length;
    let res = [];

    // 生成限制条件 
    Array.from(Array(9), (empty, i) => {
        rowSets[i] = new Set();
        colSets[i] = new Set();
        gridSets[i] = new Set();
    });
    
    // 搜集所有的空白格子 非空白内容添加至限制条件中
    for (let i = 0; i < n; i ++) {
        for (let j = 0; j < n; j++) {
            if (board[i][j] === '.') {
                res.push([i, j]);
                continue;
            }
            let number = board[i][j];
            setValue(i, j, number);
        }
    }
    
    dfs(0)
    
    // 以限制条件 为每一个空白盒子递归添加 1-9 数字
    function dfs(dep) {
        if (dep >= res.length) return true;

        let [i, j] = res[dep];

        for (let number = 1; number <= 9; number ++) {
            let value = String(number);
            if (inValid(i, j, value)) continue;
            
            setValue(i, j, value);
            if (dfs(dep + 1)) {
                board[i][j] = value;
                return true;
            }

            clearValue(i, j, value);
        }

        return false;
    }
    
    function setValue(i, j, number) {
        let {rowSet, colSet, gridSet} = getSet(i, j);    
        
        rowSet.add(number);
        colSet.add(number);
        gridSet.add(number);    
    } 

    function clearValue(i, j, number) {
        let {rowSet, colSet, gridSet} = getSet(i, j);    
        rowSet.delete(number);
        colSet.delete(number);
        gridSet.delete(number);    
    }

    function inValid(i, j, number) {
        let {rowSet, colSet, gridSet} = getSet(i, j);

        return (rowSet.has(number) || colSet.has(number) || gridSet.has(number));
    }

    function getSet(i, j) {
        let index = (i / 3 | 0) * 3 + (j / 3 | 0);
        let rowSet = rowSets[i];
        let colSet = colSets[j];
        let gridSet = gridSets[index];
  
        return {rowSet, colSet, gridSet};
    }
};