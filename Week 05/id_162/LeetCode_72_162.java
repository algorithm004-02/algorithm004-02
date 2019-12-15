
class Solution {
    
    public int minDistance(String w1, String w2) {
        int l1 = w1.length();
        int l2 = w2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];
        for (int j = 1; j <= l2; j++) dp[0][j] = dp[0][j - 1] + 1;
        for (int i = 1; i <= l1; i++) dp[i][0] = dp[i - 1][0] + 1;

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (w1.charAt(i - 1) == w2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                }
            }
        }
        return dp[l1][l2];
    }
}
