package com.algorithm.qinchao.homework.week05;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/11/14 10:35
 * @description 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 * <p>
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_53_202 {
    /**
     * 子问题：自身最大，或者自身加上之前的最大 f(i) = Max(nums[i],nums[i]+f(i-1)) + num[i]
     * 状态数组：f[i]
     * dp方程：f[i] =Max(nums[i],nums[i]+f[i-1]) + num[i]
     *
     * @param nums
     * @return
     */
    public static int maxSubArrayByDp(int[] nums) {
        int[] result = nums;
        for (int i = 1; i < nums.length; i++) {
            result[i] = Math.max(nums[i], nums[i] + result[i - 1]);
        }
        int max = result[0];
        for (int i = 1; i <result.length ; i++) {
            max = Math.max(max, result[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(LeetCode_53_202.maxSubArrayByDp(nums));
    }
}
