public class LeetCode_32_047 {

    public int longestValidParentheses(String s) {
        if (s.length() <= 1) {
            return 0;
        }
        int[] dp = new int[s.length()];
        int maxLen = 0;
        for (int i = 1; i < s.length(); i ++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i - 2 >= 0 ? dp[i - 2] : 0) + 2;
                } else if(i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '('){
                    dp[i] = dp[i - 1] + ((i - dp[i - 1] - 2) >= 0 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxLen = Math.max(maxLen, dp[i]);
            }
        }
        return maxLen;
    }
}

