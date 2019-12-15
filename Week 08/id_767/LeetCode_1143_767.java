package algorithm.LeetCode;

/**
 * describe:
 *
 * @author lixilong
 * @date 2019/11/17
 */
public class _1143_LongestCommonSubsequence {

 /**
  * 1143
  经验，从最后一个字符看起，而不是从前面看起
  两个字符串对比问题，一般可以考虑二维数组

  */

  public int longestCommonSubsequence(String text1, String text2) {
    if (text1.isEmpty() || text2.isEmpty())
      return 0;
    int n = text1.length(), m = text2.length();
    int[][] dp = new int[m + 1][n + 1];

    for (int i = 0; i < m + 1; i++)
      for (int j = 0; j < n + 1; j++)
        if (text1.charAt(i - 1) == text2.charAt(j - 1))
          dp[i][j] = 1 + dp[i - 1][j - 1];
        else
          dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);

    return dp[m][n];
  }
}
