/**
 * 不同的子序列
 */
class Solution {
    //设dp[i][j]表示s[:i]包含子序列t[:j]的个数，则：
    //当s[i]参与组成子序列时，有：dp[i][j] = dp[i - 1][j - 1]（分别去除最后一个字符，求子问题）；
    //当s[i]不参与组成子序列时，有：dp[i][j] = dp[i - 1][j]（t不变，而s去掉最后一个字符，求子问题）。
    //如果s[i] = t[j] 我可以让s[i] 参与形成子序列，也可以不让它参与 dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
    //如果s[i] != t[j] 对不起，不能让s[i] 参与形成子序列 dp[i][j] = dp[i - 1][j]; dp数组结果：
    //.  t: "", r  a  b  b  i  t
    // s:""  1, 0, 0, 0, 0, 0, 0
    //   r.  1, 1, 0, 0, 0, 0, 0
    //   a   1, 1, 1, 0, 0, 0, 0
    //   b.  1, 1, 1, 1, 0, 0, 0
    //   b.  1, 1, 1, 2, 1, 0, 0
    //   b.  1, 1, 1, 3, 3, 0, 0
    //   i.  1, 1, 1, 3, 3, 3, 0
    //   t.  1, 1, 1, 3, 3, 3, 3
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        //初始化dp条件：当j == 0 时，表示t的子序列为“” s[:i] 所有序列里都只有一个空串。
        for (int i = 0; i <= s.length(); i++) {  dp[i][0] = 1; }
        //动态推演：
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}