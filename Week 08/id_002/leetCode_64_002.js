/**
 * dfs 
 * 1. dfs 时间复杂度为O(2^n) 空间复杂度O(n)
 * @param {number[][]} grid
 * @return {number}
 */
var minPathSum = function(grid) {
    let m = grid.length;
    let n = grid[0].length;
    let _cache = new Map();

    return dfs(m - 1, n - 1)
    function dfs(r, c)  {
        // 1.避免重复计算对结果进行缓存 
        let key = `${r},${c}`;
        if (_cache.has(key)) return _cache.get(key);

        // 2. 因为是求最小值 所以超出边界的值为无穷大
        if (r < 0 || c < 0) return Number.POSITIVE_INFINITY;
        
        // 3. 到达起点位置返回起点的值即可
        if (r === 0 && c === 0) return grid[0][0];

        // 4. 下转到下一层 进行求解
        let le = dfs(r - 1, c);
        let ri = dfs(r, c - 1);

        // 5. 得出最小值，并设置缓存
        let res = Math.min(le, ri) + grid[r][c];
        _cache.set(key, res);
        
        // 5. 返回最小值
        return res;
    }
};
// DP
//      a. 重复子问题
//          f[i][j] = min(f[i - 1][j], f[i][j - 1]) + grid[i][j]
//      b. 定义状态数组
//          d[i][j] 格子第i,j最小路径
//      c. dp方程
//          dp[i][j] = min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]

/**
 * dp
 * 时间复杂度O(m * n) 空间复杂度O(m * n)
 * @param {number[][]} grid
 * @return {number}
 */
var minPathSum = function(grid) {
    let m = grid.length;
    let n = grid[0].length;

    let dp = Array.from(Array(m), () => Array(n).fill(Number.POSITIVE_INFINITY));
    dp[0][0] = grid[0][0];

    for(let i = 0; i < m; i ++) {
        for (let j = 0; j < n; j ++) {
            if (i === 0 && j === 0) continue;

            dp[i][j] = (i === 0 ? dp[i][j - 1] : j === 0 ?  dp[i - 1][j] : Math.min(dp[i - 1][j], dp[i][j - 1])) + grid[i][j];
        }
    }

    return dp[m - 1][n - 1];
};

/**
 * dp 状态压缩
 * 时间复杂度O(m * n) 空间复杂度O(m * n)
 * @param {number[][]} grid
 * @return {number}
 */
var minPathSum = function(grid) {
    let m = grid.length;
    let n = grid[0].length;

    let dp = Array(n).fill(Number.POSITIVE_INFINITY);
    dp[0] = grid[0][0];

    for(let i = 0; i < m; i ++) {
        for (let j = 0; j < n; j ++) {
            if (i === 0 && j === 0) continue;

            dp[j] = (i === 0 ? dp[j - 1] : j === 0 ?  dp[j] : Math.min(dp[j], dp[j - 1])) + grid[i][j];
        }
    }

    return dp[n - 1];
};