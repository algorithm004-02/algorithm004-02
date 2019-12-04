package com.kaiyun.leetcode;

/**
 * @program: algorithms
 * @description:
 * @author: Kaiyun
 * @create: 2019-11-19 07:28
 **/
public class LeetCode_53_157 {
    public int maxSubArray(int[] nums) {
//        int result = Integer.MIN_VALUE;
//        int m = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            nums[i] = nums[i] + Math.max(0, nums[i - 1]);
//            m = nums[i];
//        }
//        return ;

        if(nums == null || nums.length == 0){
            return Integer.MIN_VALUE;
        }
        int res = Integer.MIN_VALUE;
        int len = nums.length;
        int[] dp = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            if (dp[i - 1] >= 0) {
                dp[i] = dp[i - 1] + nums[i - 1];
            } else {
                dp[i] = nums[i - 1];
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
