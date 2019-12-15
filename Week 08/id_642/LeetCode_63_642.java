package Week8;

/**
 * @Author: xiang1.li
 * @Date: 2019/12/8 21:13
 * https://leetcode-cn.com/problems/unique-paths-ii/
 */
public class L63 {

  /**
   * 1、dp问题，使用一维数组dp[n]定义中间状态，从上往下每一层计算，递推出最终结果。
   * 2、dp[i] == 0表示此路不通，否则是走到这的不同路径数目
   * 3、没有障碍物时 dp[j] = dp[j-1] + dp[j]，有障碍物也是同样的。不同的是走不通了就是0，
   *    上和左都走不通那就是0+0，那还是0
   * */
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int n = obstacleGrid[0].length;
    int[] dp = new int[n];
    for (int i = 0; i < n; i++) {
      if (obstacleGrid[0][i] == 1) {
        break;
      }
     dp[i] = 1;
    }
    for (int i = 1; i < obstacleGrid.length; i++) {
      if (dp[0] == 1 && obstacleGrid[i][0] == 1) {
        // 每一行第一列如果不能走了记录下
        dp[0] = 0;
      }
      for (int j = 1; j < n; j++) {
        dp[j] = obstacleGrid[i][j] == 1 ? 0 : (dp[j-1] + dp[j]);
      }
    }
    return dp[n-1];
  }
}
