package week5;

import java.util.Arrays;

/**
 * @Author: xiang1.li
 * @Date: 2019/11/12 08:02
 * https://leetcode-cn.com/problems/unique-paths/
 */
public class L62 {

  /**
   * 从格子的左上角走到右下角右多少走法，只能往右、往下。 动态规划是递推，递推公式。 1、走到它的走法 = 走到它左边的走法 + 走到它上面的走法
   * 2、从左上角开始走，它走到第一排、第一列的格子走法都是1。
   */
  public int uniquePaths(int m, int n) {
    int[][] dp = new int[m][n];
    for (int i = 0; i < n; i++) {
      dp[0][i] = 1;
    }
    for (int i = 0; i < m; i++) {
      dp[m][0] = 1;
    }
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
      }
    }
    return dp[m - 1][n - 1];
  }

  /**
   * 优化版本，递推，只使用一维数组存储。
   * 依次从最底层网上累加，一维数组和那层的对应关系是相反的，这样累加到最后一层 cur[n-1]就是最终结果.
   * */
  public int uniquePaths1(int m, int n) {
    int[] cur = new int[n];
    // 最后一排走法都是1
    Arrays.fill(cur, 1);
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        // 计算它时，j-1的是自己右边的，j是自己下面的
        cur[j] += cur[j - 1];
      }
    }
    return cur[n - 1];
  }
}
