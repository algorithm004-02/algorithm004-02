package com.algorithm.qinchao.homework.week05;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/11/14 13:11
 * @description 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 * 示例 1:
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_152_202 {
    /**
     * 子问题：fmax(i) = max(fmax(i-1)*nums[i],fmin(i-1)*nums[i])
     * 状态函数：max[i]
     * dp方程：fmax[i] = max(fmax[i-1]*nums[i],fmin[i-1]*nums[i])
     * @param nums
     * @return
     */
    public static int maxProduct(int[] nums) {
        int tempMax = 1;
        int tempMin = 1;
        int max = nums[0];
        for (int num : nums) {
            //最大变最小，最小变最大
            if (num < 0) {
                int temp = tempMax;
                tempMax = tempMin;
                tempMin = temp;
            }
            //有可能这个数是0
            tempMax = Math.max(tempMax * num, num);
            tempMin = Math.min(tempMin * num, num);
            max = Math.max(tempMax, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        System.out.println(LeetCode_152_202.maxProduct(nums));
    }
}
