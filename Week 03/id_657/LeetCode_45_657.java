package com.arithmetic.arithmetic.week03;

public class LeetCode_45_657 {
    public int jump(int[] nums) {
        if(nums.length == 1) return 1;
        int[] step = new int[nums.length], dp = new int[nums.length];
        step[1] = nums[0];
        for(int i = 1; i < nums.length; ++i) {
            dp[i] = step[dp[i-1]] >= i ? dp[i-1] : dp[i-1]+1;

            if(dp[i]+1 < nums.length)
                step[dp[i]+1] = Math.max(step[dp[i]+1], i+nums[i]);
        }
        return dp[nums.length-1];
    }

}
