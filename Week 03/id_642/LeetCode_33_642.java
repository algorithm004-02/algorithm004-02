package week3.work;

/**
 * @Author: xiang1.li
 * @Date: 2019/11/1 00:24
 */
public class L33 {
  /**
   * 思路
   * 1、二分法找到最小值的位置.
   * 2、左右两边二分查找target.
   *
   * 二分法的边界条件真的是一定要判断准确
   * */
  public int search(int[] nums, int target) {
    int minIndex = getMinIndex(nums);
    int left = serach(nums, target, 0, minIndex - 1);
    int right = serach(nums, target, minIndex, nums.length - 1);
    return left > right ? left : right;
  }

  /** 获取旋转后最小值的位置，根据它就能判断数组旋转了多少 */
  public int getMinIndex(int[] nums) {
    int left = 0;
    int right = nums.length - 1;
    while (left < right) {
      int mid = (right + left) >> 1;
      /** 中间值大于right，最小值就在右边，否则是在左边或自己本身 */
      if (nums[mid] > nums[right]) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return left;
  }

  public int serach(int[] nums, int target, int i, int j) {
    while (i <= j) {
      int mid = (i + j) >> 1;
      if (nums[mid] == target) {
        return mid;
      }
      if (nums[mid] > target) {
        j = mid - 1;
      } else {
        i = mid + 1;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    L33 l33 = new L33();
    int[] array = {6, 7, 8, 9, 1, 2, 3, 4, 5};
    System.out.println(l33.getMinIndex(array));
    int[] arr = {1, 2, 3, 4, 5};
    System.out.println(l33.serach(arr, 5, 0, arr.length - 1));
  }
}
