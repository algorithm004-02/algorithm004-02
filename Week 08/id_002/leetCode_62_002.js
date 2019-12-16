/** 62. 不同路径 **/

/**
 * 1. dfs + cache
 * 时间复杂度为O(2^n) 空间复杂度O(n)
 * @param {number} m
 * @param {number} n
 * @return {number}
 */
var uniquePaths = function(m, n) {
    let _cache = new Map();
    return dfs(0, 0);

    function dfs(r, c) {
        let key = `${r},${c}`;
        if (_cache.has(key)) return _cache.get(key);

        if (r >= m || c >= n) return 0;

        if (m - 1 === r || n - 1 === c) return 1;

        let le = dfs(r + 1, c);
        let ri = dfs(r, c + 1);
        let res = le + ri;
        _cache.set(`${r},${c}`, res);

        return res;
    }
};

/**
 * dp 解法
 * 时间复杂度为O(m * n) 空间复杂度为O(m * n)
 * @param {number} m
 * @param {number} n
 * @return {number}
 */
var uniquePaths = function(m, n) {
    let dp = Array.from(Array(m), () => Array(n).fill(0));

    // 初始化状态数组
    for (let i = 0; i < m; i ++) {
        for (let j = 0; j < n; j ++) {
            if (i === 0 || j === 0) dp[i][j] = 1;
        }
    }

    // 进行dp递推
    for (let i = 1; i < m; i ++) {
        for (let j = 1; j < n; j ++) {
            dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        }
    }

    return dp[m - 1][n - 1];
};

/**
 * dp 状态压缩 
 * 时间复杂度O(m*n) 空间复杂度为O(n)
 * @param {number} m
 * @param {number} n
 * @return {number}
 */
var uniquePaths = function(m, n) {
    // 1. 状态压缩
    let dp = Array.fill(1);

    // 进行dp递推
    for (let i = 1; i < m; i ++) {
        for (let j = 1; j < n; j ++) {
            dp[j] = dp[j] + dp[j - 1];
        }
    }

    return dp[n - 1];
};