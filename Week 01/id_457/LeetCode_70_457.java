class Solution {
    public int climbStairs(int n) {
         if (n==1) {
             return n;
         }
        int[] dp = new int[n+1];  //数组长度设为n+1，原因：本代码操作从下标为1的数组元素开始的，便于理解。
        dp[1] = 1;   
        dp[2] = 2;
        for (int i = 3; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}