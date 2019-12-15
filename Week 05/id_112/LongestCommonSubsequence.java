package datastruct.dp;

/**
 * 1143：最大公共子序列
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) {

    }

    public int longestCommonSubsequence(String text1,String text2) {
        int m = text1.length();
        int n = text2.length();
        if (m == 0 || n == 0) return 0;
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[m][n];
    }
}
