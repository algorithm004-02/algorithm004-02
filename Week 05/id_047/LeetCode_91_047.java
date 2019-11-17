public class LeetCode_91_047 {

    public int numDecodings(String s) {

        int[] dp = new int[s.length() + 1];
        dp[s.length()] = 1;
        if (s.charAt(s.length() - 1) != '0') {
            dp[s.length() - 1] = 1;
        }
        for (int i = s.length() - 2; i >= 0; i --){
            if (s.charAt(i) == '0') {
                continue;
            }

            dp[i] = dp[i + 1];
            int ten = (s.charAt(i) - '0') * 10;
            int one = s.charAt(i + 1) - '0';
            if ((ten + one) <= 26) {
                dp[i] = dp[i + 1] + dp[i + 2];
            }
        }
        return dp[0];
    }
}
