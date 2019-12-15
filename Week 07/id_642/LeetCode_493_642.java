package Week7;

/**
 * @Author: xiang1.li
 * @Date: 2019/12/4 00:06
 * https://leetcode-cn.com/problems/reverse-pairs/
 */
public class L493 {
  int count = 0;

  public int reversePairs(int[] nums) {
    mergeSort(nums, 0, nums.length - 1);
    return count;
  }

  private void mergeSort(int[] nums, int start, int end) {
    if (start >= end) {
      return;
    }
    int mid = (start + end) >> 1;
    mergeSort(nums, start, mid);
    mergeSort(nums, mid + 1, end);
    merge(nums, start, mid, end);
  }

  private void merge(int[] nums, int start, int mid, int end) {
    int[] temp = new int[end - start + 1];
    int i = start;
    int j = mid + 1;
    int k = 0;
    // 用来记录每次满足的逆序对的个数
    int c = start;
    for (int l = j; l <= end; l++) {
      // 对于后半部分的每一个元素，统计逆序对的个数
      while (c <= mid && (long)nums[c] <= 2L * nums[l]) {
        c++;
      }
      while (i <= mid && nums[i] <= nums[l]) {
        temp[k++] = nums[i++];
      }
      temp[k++] = nums[l];
      count += (mid - c + 1);
    }
    while (i <= mid) {
      temp[k++] = nums[i++];
    }
    System.arraycopy(temp, 0, nums, start, temp.length);
  }

  public static void main(String[] args) {
    L493 l493 = new L493();
    int[] arr = {1,3,2,3,1};
    System.out.print(l493.reversePairs(arr));
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }
}
