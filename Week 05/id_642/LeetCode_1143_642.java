package week5;

/**
 * @Author: xiang1.li
 * @Date: 2019/11/14 07:04
 */
public class L1143 {
  /**
   * 最长公共子序列问题，dp.
   * 1、用一个二维数组存储中间结果，依次计算最长公共子序列长度，一直计算到最后.
   * 2、如果text1CharArray[i] == text2CharArray，i和j的公共子序列就是 i - 1 和 j - 1的值  + 1
   * 3、如果2不成立，i和j的值，就等于 i、j-1 和 j、i-1两个中最大的那么.
   * */
  public int longestCommonSubsequence(String text1, String text2) {
    // 这里长度多存储一个单位，就不用特殊考虑 i - 1 j - 1 会越界了.
    int[][] result = new int[text1.length() + 1][text2.length() + 1];
    for (int i = 1; i < text1.length() + 1; i++) {
      // 这比较字符的时候比较的就是 i - 1 j - 1了.
      char c1 = text1.charAt(i-1);
      for (int j = 1; j < text2.length() + 1; j++) {
        char c2 = text2.charAt(j-1);
        if (c1 == c2) {
          result[i][j] = result[i-1][j-1] + 1;
        } else {
          result[i][j] = Math.max(result[i-1][j], result[i][j-1]);
        }
      }
    }
    return result[text1.length()][text2.length()];
  }
}
