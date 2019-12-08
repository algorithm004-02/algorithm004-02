package week3.work;

/**
 * @Author: xiang1.li
 * @Date: 2019/11/1 21:42
 */
public class L153 {
  public int findMin(int[] nums) {
    int left = 0;
    int right = nums.length - 1;
    while (left < right) {
      int mid = (right + left) >> 1;
      if (nums[mid] > nums[right]) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return nums[left];
  }
}
