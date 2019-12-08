public class LeetCode_32_677 {
    public int longestValidParentheses(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        int max = 0;
        int[] dp = new int[s.length()];

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        LeetCode_32_677 s = new LeetCode_32_677();
        int ans = s.longestValidParentheses("()(()");
        System.out.println(ans);

        ans = s.longestValidParentheses("");
        System.out.println(ans);

        ans = s.longestValidParentheses(")()())");
        System.out.println(ans);

        ans = s.longestValidParentheses("(()");
        System.out.println(ans);

        ans = s.longestValidParentheses("()(())");
        System.out.println(ans);
    }
}
