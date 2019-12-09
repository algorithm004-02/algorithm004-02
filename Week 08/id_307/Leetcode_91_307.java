class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0 || s.charAt(0) == '0') {
            return 0;
        }
        //0~n可以解码多少种结果
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            char c = s.charAt(i - 1);
            if (c > '0') {
                dp[i] += dp[i - 1];
            }
            if ((s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && c < '7'))) {
                dp[i] += dp[i - 2];
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[n];
    }
}