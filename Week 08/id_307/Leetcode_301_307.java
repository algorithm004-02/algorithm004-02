//1.dp[i] i:0~i最长上升序列
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n];
        // 初始值        
        dp[0] = 1;
        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    max = Math.max(dp[j], max);
                }
            }
            dp[i] = max + 1;
            result = Math.max(dp[i], result);
        }
        return result;
    }
}