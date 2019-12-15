/**
 * 1143. 最长公共子序列
 */
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] charArray1 = text1.toCharArray();
        char[] charArray2 = text2.toCharArray();
        
        int m = charArray1.length+1;
        int n = charArray2.length+1;
        
        int[][] dp = new int[m][n];
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (charArray1[i-1] == charArray2[j-1]) { //末端相同的情况下
                    dp[i][j] = dp[i-1][j-1]+1;
                } else { //末端不同的情况下
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m-1][n-1];
    }
}