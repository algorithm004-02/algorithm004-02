class Solution {
    public int numDecodings(String s) {
        if (null == s || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            //vaild number must be between 1-26,so only supports x & xx two forms.
            int first = Integer.parseInt(s.substring(i - 1, i));
            int second = Integer.parseInt(s.substring(i - 2, i));
            if (first > 0 && first < 10) {
                dp[i] += dp[i - 1];
            }
            if (second > 9 && second < 27) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];

    }
}