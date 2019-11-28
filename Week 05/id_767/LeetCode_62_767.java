package algorithm.LeetCode;

import java.util.Arrays;

/**
 * describe:
 *
 * @author lixilong
 * @date 2019/11/17
 */
public class _62_UniquePaths {



  //找重复性
  // 对比 62题
  //  O(m*n)/O(m*n)
  public int uniquePaths1(int m, int n) {
    int[][] dp = new int[m][n];

    for (int i = 0; i < n; i++) dp[0][i] = 1; //自底向上初始化
    for (int i = 0; i < m; i++) dp[i][0] = 1;

    for (int i = 1; i < m; i++)
      for (int j = 1; j < n; j++)  //妈呀，居然把 m 和 n的遍历顺序整反了
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1]; //递推关系

    return dp[m - 1][n - 1];
  }


  //O(m*n)/O(n)
  public int uniquePaths2(int m, int n) {
    int[] cur = new int[n];

    Arrays.fill(cur, 1);//初始化一行值

    for (int i = 1; i < m; i++)
      for (int j = 1; j < n; j++)
        cur[j] += cur[j - 1]; //只需要存最近一行，从当前行往上垒

    return cur[n - 1];
  }

}
