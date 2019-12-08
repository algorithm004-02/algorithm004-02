/** 120. 三角形最小路径和 **/
/** 
 * a. 重复性(分治): problem(i, j) = min(sub(i + 1, j), sub(i + 1, j + 1)) + a(i, j);
 * b. 定义状态数组： f[i, j]
 * c. DP方程： f[i, j] = min(f[i + 1][j], f[i + 1][j + 1]) + a[i, j]   
 */

 /**
 * @param {number[][]} triangle
 * @return {number}
 */
var minimumTotal = function(triangle) {
    for(let i = triangle.length - 2; i >= 0; i --) {
        for(let j = 0; j < triangle[i].length; j ++) {
            triangle[i][j] += Math.min(triangle[i + 1][j], triangle[i + 1][j + 1]);
        }
    }

    return triangle[0][0];
}

/**
 * 一维存储空间
 * @param {number[][]} triangle
 * @return {number}
 */
var minimumTotal2 = function(triangle) {
    let dp = [...triangle[triangle.length - 1]];
    for(let i = triangle.length - 2; i >= 0; i --) {
        for(let j = 0; j < triangle[i].length; j ++) {
            dp[j] = Math.min(dp[j], dp[j + 1]) + triangle[i][j];
        }
    }

    return dp[0];
};

/**
 * 递归 记忆化搜索
 * @param {number[][]} triangle
 * @return {number}
 */
var minimumTotal3 = function(triangle) {
    return dfs(0, 0);
    function dfs(i, j, map = {}) {
        if (i >= triangle.length - 1) return triangle[i][j];

        let left = map[`${i + 1},${j}`];
        let right = map[`${i + 1},${j + 1}`];

        if (typeof left === 'undefined') {
            left = dfs(i + 1, j, map);
            map[`${i + 1},${j}`] = left;
        }

        if (typeof right === 'undefined') {
            right = dfs(i + 1, j + 1, map);
            map[`${i + 1},${j + 1}`] = right;
        }
        
        return Math.min(left, right) + triangle[i][j];
    }
};