class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // 如果第一个元素是1（有障碍物），就直接返回0（没有路径）
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int width = obstacleGrid[0].length;
        int[] dp = new int[width];
        dp[0] = 1;
        for (int[] row: obstacleGrid) {
            for (int j = 0; j < width; j++) {
                if (row[j] == 1) {
                    dp[j] = 0;
                } else if (j > 0) {
                    dp[j] += dp[j-1];
                }
            }
        }
        return dp[width-1];
    }
}