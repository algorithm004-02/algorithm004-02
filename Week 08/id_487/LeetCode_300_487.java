class LeetCode_300_487 {

    public int lengthOfLIS(int[] nums) {

        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        //1.d[i]：表示当前位置最长上升子序列长度
        int[] dp = new int[len];
        Arrays.fill(dp,1);
        int maxLenth = 1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            maxLenth = Math.max(maxLenth, dp[i]);
        }
        return maxLenth;
    }
}