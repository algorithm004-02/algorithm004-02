class Solution {
    public int splitArray(int[] nums, int m) {
         if(nums == null) {
            return -1;
        }
        
        int[][] dp = new int[m][nums.length];
        dp[0][0] = nums[0];
        for(int i=1; i<nums.length; i++) {
            dp[0][i] = nums[i]+dp[0][i-1];
        }
        
        for(int i=1; i<m; i++){
            for(int j=i; j<nums.length; j++) {
                int min = Integer.MAX_VALUE;
                for(int k=0; k<j; k++){
                    min = Math.min(min, Math.max(dp[i-1][k], dp[0][j]-dp[0][k]));
                }
                dp[i][j] = min;
            }
        }
        return dp[m-1][nums.length-1];
    }
}