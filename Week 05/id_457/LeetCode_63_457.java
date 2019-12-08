/**
 * 63. 不同路径 II  （有障碍物的情况下）
 */
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int width = obstacleGrid[0].length;
        int[] dp = new int[width];
        dp[0] = 1;  //1.为什么要初始化为1

        for (int[] row : obstacleGrid) {
            for (int j = 0; j < width; j++) {
                if (row[j] == 1) {
                    dp[j] = 0;
                } else if (j > 0) {  // 2. j>0判断是否多余
                    dp[j] += dp[j-1];
                }
            }
        }
        return dp[width-1];
    }
}