package Week08;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径
 * <p>
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * <p>
 * 说明：m 和 n 的值均不超过 100。
 */
public class Solution63 {

    //自底向上
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        /** dp状态表示 路径数量 */
        int row = obstacleGrid.length;
        int column = obstacleGrid[0].length;

        //起点或终点有障碍物，直接返回0
        if(obstacleGrid[row-1][column-1] == 1 || obstacleGrid[0][0] == 1){
            return 0;
        }

        /** dp数组 */
        int[][] dp = new int[row][column];
        //自底向上
        dp[row - 1][column - 1] = 1;


        /** 数组中特殊处理 */
        //最后一列初始化
        for (int i = row - 2; i >= 0; i--) {
            if (obstacleGrid[i][column - 1] != 1)
                dp[i][column - 1] = dp[i + 1][column - 1];
        }

        //最后一行初始化
        for (int j = column - 2; j >= 0; j--) {
            if (obstacleGrid[row - 1][j] != 1)
                dp[row - 1][j] = dp[row - 1][j + 1];
        }


        /** dp状态转移方程 */
        //剩余行列
        for (int i = row - 2; i >= 0; i--) {
            for (int j = column - 2; j >= 0; j--) {
                if (obstacleGrid[i][j] != 1) {
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                }
            }
        }

        return dp[0][0];

    }
}
