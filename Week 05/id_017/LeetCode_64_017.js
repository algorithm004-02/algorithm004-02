
/**
 * 64.最小路径和
 * @param {number[][]} grid
 * @return {number}
 */
var minPathSum = function(grid) {
    // 解法一 动态规划
    //子问题 dp[i][j] = min(dp[i-1][j],dp[i][j-1])+grid[i][j]
    //状态
    //dp方程
    // 时间复杂度 O(m*n)
    let n = grid.length;
    let m = grid[0].length;
    var dp = Array.from(new Array(n),() => new Array(m));

    for(let i = 0; i < n; i++) {
        for(let j = 0; j < m; j++) {
          if(i!=0 && j!=0) {
             dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
          }else if (i == 0 && j != 0) {
              dp[i][j] = dp[i][j-1] + grid[i][j];
          }else if (i != 0 && j == 0) {
              dp[i][j] = dp[i-1][j] + grid[i][j];
          }else{
              dp[i][j] = grid[i][j];
          }
        }
    }
    
    return dp[n-1][m-1];
    //可以优化 空间 使用原来数组
};