package Week08.Chapter20;

public class LeetCode_8_005 {
    public String longestPalindrome(String s) {
        int n = s.length();
        String res ="";
        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1]);
                if (dp[i][j] && j - i + 1 > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s ="babad";
        final LeetCode_8_005 test = new LeetCode_8_005();
        System.out.println(test.longestPalindrome(s));
    }
}
