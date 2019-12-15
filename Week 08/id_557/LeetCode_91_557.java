//一条包含字母 A-Z 的消息通过以下方式进行了编码： 
//
// 'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
// 
//
// 给定一个只包含数字的非空字符串，请计算解码方法的总数。 
//
// 示例 1: 
//
// 输入: "12"
//输出: 2
//解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
// 
//
// 示例 2: 
//
// 输入: "226"
//输出: 3
//解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
// 
// Related Topics 字符串 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public int numDecodings(String s) {
//        if (s == null || s.length() == 0) return 0;
//        int n = s.length();
//        int[] dp = new int[n + 1];
//        dp[0] = 1;
//        dp[1] = s.charAt(0) == '0' ? 0 : 1;
//        for (int i = 2; i <= n; i++) {
//            int first = Integer.valueOf(s.substring(i - 1, i));
//            int second = Integer.valueOf(s.substring(i - 2, i));
//            if (first >= 1 && first <= 9) {
//                dp[i] += dp[i - 1];
//            }
//            if (second >= 10 && second <= 26) {
//                dp[i] += dp[i - 2];
//            }
//        }
//        return dp[n];
//    }

    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0) return 0;

        int[] memo = new int[n+1];
        memo[n]  = 1;
        memo[n-1] = s.charAt(n-1) != '0' ? 1 : 0;

        for (int i = n - 2; i >= 0; i--)
            if (s.charAt(i) == '0') continue;
            else memo[i] = (Integer.parseInt(s.substring(i,i+2))<=26) ? memo[i+1]+memo[i+2] : memo[i+1];

        return memo[0];
    }

}
//leetcode submit region end(Prohibit modification and deletion)
