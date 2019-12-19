91.解码方法
一条包含字母 A-Z 的消息通过以下方式进行了编码：
'A' -> 1
'B' -> 2
...
'Z' -> 26
给定一个只包含数字的非空字符串，请计算解码方法的总数。

示例 1:
输入: "12"
输出: 2
解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
示例 2:
输入: "226"
输出: 3
解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 

状态转移方程：
dp[i] = dp[i+1] + dp[i+2]

class Solution {
    int[] memo;
     public int numDecodings(String s) {
         memo = new int[s.length() + 1];
         Arrays.fill(memo, -1);
         return getAns(s, 0);
     }
     public int getAns(String s, int num) {
         if (num == s.length()) {
             return 1;
         }
         if (s.charAt(num) == '0') {
             return 0;
         }
         if (memo[num] > -1) {
             return memo[num];
         }
         int ans1 = getAns(s, num + 1);
         int ans2 = 0;
         if (num < s.length() - 1) {
             // 判断前两个数字是否  >26？
             if ((s.charAt(num) - '0') * 10 + (s.charAt(num + 1) - '0') <= 26) {
                 ans2 = getAns(s, num + 2);
             }
         }
         memo[num] = ans1 + ans2;
         return ans1 + ans2;
     }
 }