public class LeetCode_91_047 {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int length = s.length();
        int[] dp = new int[length];
        dp[0] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 1; i < length; i++) {
            int first = Integer.parseInt(s.substring(i, i + 1));
            int second = Integer.parseInt(s.substring(i - 1, i + 1));
            if (first >= 1 && first <= 9) {
                dp[i] += dp[i - 1];
            }
            if (second >= 10 && second <= 26) {
                dp[i] += ((i - 2) < 0 ? 1 : dp[i - 2]);
            }
        }
        return dp[length - 1];
    }
}
