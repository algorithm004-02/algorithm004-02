package com.itliusir.dynamic;

import java.util.Arrays;

/**
 * problem.300
 *
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 *
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 *
 * @author liugang
 * @date 2019-12-08
 */
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(new LongestIncreasingSubsequence().lengthOfLISTwo(nums));
    }

    /**
     * method 1 -> time O(2^n) space O(2^n)
     * 暴力递归
     * @author liugang
     * @date 2019-12-08 21:04:26
     */
    public int lengthOfLIS(int[] nums) {
        return lengthOfLIS(nums, Integer.MIN_VALUE, 0);
    }

    private int lengthOfLIS(int[] nums, int prev, int curpos) {
        if (curpos == nums.length) {
            return 0;
        }
        int taken = 0;
        if (nums[curpos] > prev) {
            taken = 1 + lengthOfLIS(nums, nums[curpos], curpos + 1);
        }
        int nottaken = lengthOfLIS(nums, prev, curpos + 1);
        return Math.max(taken, nottaken);
    }

    /**
     * method 2 -> time O(n^2) space O(n)
     *
     * dp求解
     *
     * @author liugang
     * @date 2019-12-08 21:36:49
     */
    public int lengthOfLISTwo(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }


}
