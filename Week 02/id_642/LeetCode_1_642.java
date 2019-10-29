package week2.work;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xiang1.li
 * @Date: 2019/10/21 21:15
 */
public class L1 {
  /**
   * 遍历数组，把所有的数放在map中，遍历时先判断 target - nums[i] 是否在map中，随后
   * 把nums[i] 放在map中.
   * */
  public int[] twoSum(int[] nums, int target) {
    int[] ret = new int[2];
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int m = target - nums[i];
      if (map.containsKey(m)) {
        ret[0] = map.get(m);
        ret[1] = i;
        break;
      }
      map.put(nums[i], i);
    }
    return ret;
  }

  /***
   * 如果是找两个数，不是找坐标的话，也可以用双指针的左右夹逼，下面是实现.
   * 解决此问题下面的这个解法不可以，排序后位置变了，还得想办法记住原始位置.
   */
  public int[] twoSum1(int[] nums, int target) {
    int[] ret = new int[2];
    Arrays.sort(nums);
    int i = 0;
    int j = nums.length - 1;
    while (i < j) {
      if (nums[i] > target) {
        break;
      }
      int v = nums[i] + nums[j];
      if (v < target) {
        i++;
      } else if (v > target) {
        j--;
      } else {
        ret[0] = nums[i];
        ret[1] = nums[j];
        break;
      }
    }
    return ret;
  }
}
