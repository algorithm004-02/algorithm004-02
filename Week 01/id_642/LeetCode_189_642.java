package week1;

/**
 * @Author: xiang1.li
 * @Date: 2019/10/19 23:44
 *
 * https://leetcode-cn.com/problems/rotate-array/
 */
public class RotateArray {
  public void rotate(int[] nums, int k) {
    // 反转法，首先将数组逆转，再把前k个，后n-k分别逆转
    k = k % nums.length;
    reverse(nums, 0, nums.length - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, nums.length - 1);
  }

  public void reverse(int[] nums, int i, int j) {
    while (i < j) {
      int tmp = nums[i];
      nums[i] = nums[j];
      nums[j] = tmp;
      i++;
      j--;
    }
  }
}
