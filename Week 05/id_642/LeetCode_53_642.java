package week5;

/**
 * @Author: xiang1.li
 * @Date: 2019/11/17 16:51
 * https://leetcode-cn.com/problems/maximum-subarray
 */
public class L53 {
  /**
   * 最大子数组.
   * 从0..i，第i个位置可以组成的最大子数组的值 = max(nums[i]，nums[i] + nums[i-1])
   * */
  public int maxSubArray(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }
    int max = nums[0];
    for (int i = 1; i < nums.length; i++) {
      nums[i] = Math.max(nums[i], nums[i] + nums[i-1]);
      if (nums[i] > max) {
        max = nums[i];
      }
    }
    return max;
  }
}
