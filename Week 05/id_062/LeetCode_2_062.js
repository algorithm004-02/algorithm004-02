/**给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * @param {number[][]} grid
 * @return {number}
 */
var minPathSum = function (grid) {
    var n = grid.length
    var m = grid[0].length
    var dp = Array.from(new Array(n), () => new Array(m))
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < m; j++) {
            if (i != 0 && j != 0) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]
            } else if (i == 0 && j != 0) {
                dp[i][j] = dp[i][j - 1] + grid[i][j]
            } else if (i != 0 && j == 0) {
                dp[i][j] = dp[i - 1][j] + grid[i][j]
            } else if (i == 0 && j == 0) {
                dp[i][j] = grid[i][j]
            }
        }
    }
    return dp[n - 1][m - 1]
};


var minPathSum = function (grid) {
    var dp = new Array(grid.length);
    for (let i = 0; i < grid.length; i++) {
        for (let j = 0; j < grid[0].length; j++) {
            if (i != 0 && j != 0) {
                dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j]
            } else if (i == 0 && j != 0) {
                dp[j] = dp[j - 1] + grid[i][j]
            } else if (i != 0 && j == 0) {
                dp[j] = dp[j] + grid[i][j]
            } else if (i == 0 && j == 0) {
                dp[j] = grid[i][j]
            }
        }
    }
    return dp[grid[0].length - 1]
}



