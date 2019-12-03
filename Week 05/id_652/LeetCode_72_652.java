class Solution {
    // 单独处理空字符串的dp
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return 0;
        }
        int n = word1.length();
        int m = word2.length();
        if (n == 0) {
            return m;
        } else if (m == 0) {
            return n;
        }
        int[][] dp = new int[n][m];
        for (int j = 0; j < m; j++) {
            if (word1.charAt(0) == word2.charAt(j)) dp[0][j] = j;
            else if (j != 0) dp[0][j] = dp[0][j-1] + 1;
            else dp[0][j] = 1;
        }
        for (int i = 0; i < n; i++) {
            if (word1.charAt(i) == word2.charAt(0)) dp[i][0] = i;
            else if (i != 0) dp[i][0] = dp[i-1][0] + 1;
            else dp[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = min(dp[i-1][j] + 1, dp[i][j-1] + 1, dp[i-1][j-1]);
                } else {
                    dp[i][j] = min( dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1;
                }
            }
        }
        return dp[n-1][m-1];
    }
    // 统一处理空字符串的dp
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n+1][m+1];
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1;
                }
            }
        }
        return dp[n][m];
    }

    private int min(int x, int y, int z) {
        return Math.min(x, Math.min(y, z));
    }   
}
