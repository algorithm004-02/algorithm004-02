/*
 * @lc app=leetcode.cn id=64 lang=javascript
 *
 * [64] 最小路径和
 */
// @lc code=start
/**
 * @param {number[][]} grid
 * @return {number}
 */
var minPathSum = function (grid) {
    var dp = grid;
    for (var i = 0; i < dp.length; i++) {
        for (var j = 0; j < dp[i].length; j++) {
            if (i === 0 && j === 0) {
                continue;
            }
            else if (i === 0) {
                dp[i][j] = dp[i][j - 1] + dp[i][j];
            }
            else if (j === 0) {
                dp[i][j] = dp[i - 1][j] + dp[i][j];
            }
            else {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + dp[i][j];
            }
        }
    }
    return dp[dp.length - 1][dp[dp.length - 1].length - 1];
};
// @lc code=end
