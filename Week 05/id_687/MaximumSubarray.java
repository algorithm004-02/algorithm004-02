package com.itliusir.dynamic;

/**
 * problem.53
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * @author liugang
 * @date 2019-11-17
 */
public class MaximumSubarray {

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new MaximumSubarray().maxSubArray(nums));
    }

    /**
     * method 1 -> time O(n) space O(n)
     *
     * f[i] = max(f[i - 1], 0) + a[i]
     *
     * @author liugang
     * @date 2019-11-17 20:17:09
     */
    public int maxSubArray(int[] nums) {
        int maxValue = nums[0];
        int[] dp = nums;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(0, dp[i - 1]) + nums[i];
            maxValue = Math.max(maxValue, dp[i]);
        }
        return maxValue;
    }
}
