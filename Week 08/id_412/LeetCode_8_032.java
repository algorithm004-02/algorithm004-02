package Week08.Chapter20;

public class LeetCode_8_032 {
    public int longestValidParentheses(String s) {
        int res = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            // s[i]=‘)’ s[i - 1] =‘(’  ==>  "……()"
            //
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = ")()()";
        final LeetCode_8_032 test = new LeetCode_8_032();
        System.out.println(test.longestValidParentheses(s));
    }
}
