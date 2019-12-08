package week5;

/**
 * @Author: xiang1.li
 * @Date: 2019/11/17 11:15
 * https://leetcode-cn.com/problems/edit-distance/
 *
 * 解决两个字符串的动态规划问题，一般都是用两个指针 i,j 分别指向两个字符串的最后，然后一步步往前走，缩小问题的规模
 */
public class L72 {
  public int minDistance(String word1, String word2) {
    int m = word1.length();
    int n = word2.length();
    int[][] dp = new int[m+1][n+1];
    for (int i = 0; i <= m; i++) {
      dp[i][0] = i;
    }
    for (int i = 0; i <= n; i++) {
      dp[0][i] = i;
    }
    for (int i = 1; i <= m; i++) {
      char a = word1.charAt(i - 1);
      for (int j = 1; j <= n; j++) {
        char b = word2.charAt(j - 1);
        if (a == b) {
          dp[i][j] = dp[i-1][j-1];
        } else {
          dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j-1], dp[i][j-1]), dp[i-1][j]);
        }
      }
    }
    return dp[m][n];
  }
}
