class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // 两个字符串比较，就要考虑到用二维数组，从后面字符往前看，找重复性写递推（经验）
        if (text1 == null || text2 == null) {
            return 0;
        }
        int n1 = text1.length();
        int n2 = text2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[n1][n2];  
    }
}