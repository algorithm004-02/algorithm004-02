/** 62. 不同路径 **/

/**
 4 x 7
[ 1, 1, 1, 1, 1, 1, 1 ],
[ 1, 2, 3, 4, 5, 6, 7 ],
[ 1, 3, 6, 10, 15, 21, 28 ],
[ 1, 4, 10, 20, 35, 56, 84 ]
**/

/**
 * @param {number} m
 * @param {number} n
 * @return {number}
 */
var uniquePaths = function(m, n) {
    let g = [];
    for(var i = 0; i < m; i++) {
        g[i] = [];
        for(var j  = 0; j < n; j ++) {
            g[i][j] = (i == 0 || j == 0) ? 1 : 0;
        }
    }

    for(var r = 1; r < m; r++)  {
        for(var c = 1; c < n; c++) {
            g[r][c] = g[r - 1][c] + g[r][c -1];
        }
    }

    return g[m - 1][n - 1];
};
/**
 * @param {number} m
 * @param {number} n
 * @return {number}
 */
var uniquePaths2 = function(m, n) {
    let c = Array(n).fill(1);

    for(var i = 1; i < m; i++) {
        for(var j = 1; j < n; j++) {
            c[j] += c[j - 1];
        }
    }

    return c[n -1];
};
