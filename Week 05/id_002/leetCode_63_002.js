/** 63. 不同路径 II */

/**
 * @param {number[][]} obstacleGrid
 * @return {number}
 */
var uniquePathsWithObstacles = function(obstacleGrid) {
    const n = obstacleGrid[0].length;

    let dp = Array(n).fill(0);
    dp[0] = 1;
   
    for (var row of obstacleGrid) {
        for (var j = 0; j < n; j++) {
            if (row[j] === 1) {
                dp[j] = 0;
            } else if (j > 0) {
                dp[j] += dp[j - 1];
            }
        }
    }
    
    return dp[n - 1];
};
/**
 * 递归 记忆化搜索
 * @param {number[][]} obstacleGrid
 * @return {number}
 */
var uniquePathsWithObstacles2 = function(obstacleGrid) {
    return countPaths(obstacleGrid, 0, 0);
    
    function countPaths(grid, row, col, mem = {}) {
        if (row >= grid.length) return 0;
        if (col >= grid[row].length) return 0;     

        if(grid[row][col] === 1) return 0;

        if (grid.length - 1 === row && grid[grid.length - 1].length - 1 === col) return 1;
        
        let xKey = `${row + 1},${col}`;
        let yKey = `${row},${col + 1}`;
        let preX = mem[xKey];
        let preY = mem[yKey];
        
        if (!preX) {
            preX = countPaths(grid, row + 1, col, mem);
            mem[xKey] = preX;
        }
        
        if (!preY) {
            preY = countPaths(grid, row, col + 1, mem);
            mem[yKey] = preY;
        }

        return preX + preY;
    }
};

/**
 * @param {number[][]} obstacleGrid
 * @return {number}
 */
var uniquePathsWithObstacles3 = function(obstacleGrid) {
    const arr = obstacleGrid;
    const m = obstacleGrid.length;
    const n = obstacleGrid[0].length;

    if(arr[0][0] === 1) return 0;

    arr[0][0] = 1;
    for (let i = 1; i < m; i++) {
        arr[i][0] = (arr[i][0] === 0 && arr[i - 1][0] === 1) ? 1 : 0;
    }

    for (let j = 1; j < n; j ++) {
        arr[0][j] = (arr[0][j] === 0 && arr[0][j - 1] === 1) ? 1 : 0;
    }

    for(let i = 1; i < m; i ++) {
        for(let j = 1; j < n; j ++) {
            if (arr[i][j] === 0) {
                arr[i][j] = arr[i - 1][j] + arr[i][j - 1]
            } else {
                arr[i][j] = 0;
            }
        }
    }

    return arr[m - 1][n - 1];
};