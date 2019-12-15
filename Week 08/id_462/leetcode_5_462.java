/**
 * 最长回文子串
 */
class Solution {
    public String longestPalindrome(String s) {
        // P(i,j) = true s[i,j] 是回文串
        // P(i,j) = false s[i,j] 不是回文串
        // P(i,j) = (P(i+1,j-1) && s[i] == s[j])
        int n = s.length();
        String res = "";
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j)
                        && (j - i < 2 || dp[i + 1][j - 1]);
                if (dp[i][j] && j - i + 1 > res.length()) {
                    res = s.substring(i,j + 1);
                }
            }
        }
        return res;
    }
}