package week1;

/**
 * @Author: xiang1.li
 * @Date: 2019/10/19 23:42
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicatesFromSortedArray {
  public int removeDuplicates(int[] nums) {
    int len = nums.length;
    if (len <= 1) {
      return len;
    }
    int i = 0;
    for (int j = 1; j < len; j++) {
      // i,j上元素不相等，就把j上的元素赋值到i+1的位置.
      if (nums[j] != nums[i]) {
        nums[++i] = nums[j];
      }
    }
    return i + 1;
  }
}
