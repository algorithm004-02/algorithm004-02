package Week08.Chapter19;

public class LeetCode_8_091 {
    // 276 -> 0 1
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= n; i++) {
            int first = Integer.valueOf(s.substring(i - 1, i));
            int second = Integer.valueOf(s.substring(i - 2, i));
            System.out.printf("first=%d,second=%d\n", first, second);
            if (first >= 1 && first <= 9) {
                dp[i] = dp[i] + dp[i - 1];
            }
            if (second >= 10 && second <= 26) {
                dp[i] = dp[i] + dp[i - 2];
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.println(dp[i]);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        String s = "230";
        final LeetCode_8_091 test = new LeetCode_8_091();
        System.out.println(test.numDecodings(s));
    }
}
