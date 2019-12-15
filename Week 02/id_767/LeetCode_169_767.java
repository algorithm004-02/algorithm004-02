package algorithm.LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * describe:
 *  题设已保证肯定有  MajorityElement
 * @author lixilong
 * @date 2019/10/25
 */
public class _169_MajorityElement {

  public static void main(String[] args) {
    int[] nums = {5,6,8,9,2,3,4};
    Arrays.sort(nums);
    for (int i = 0; i < nums.length; i++) {
      System.out.println(nums[i]);
    }
  }


  //方法1：暴力枚举找到出现超过 唯一一个 n/2 的数字
//Time complexity : O(n^2)  Space complexity : O(1)
  public int majorityElement(int[] nums) {
    int majorityCount = nums.length / 2;

    for (int num : nums) {
      int count = 0;
      for (int elem : nums) {
        if (elem == num) {
          count += 1;
        }
      }

      if (count > majorityCount) {
        return num;
      }

    }

    return -1;
  }


  //方法2：暴力枚举优化，HashMap用来计数
  //Time complexity : O(n)  Space complexity : O(n)

  public int majorityElement(int[] nums) {
    Map<Integer, Integer> counts = countNums(nums);

    Map.Entry<Integer, Integer> majorityEntry = null;
    for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
      if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
        majorityEntry = entry;  // entry  整体赋值
      }
    }

    return majorityEntry.getKey();
  }


  private Map<Integer, Integer> countNums(int[] nums) {
    Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
    for (int num : nums) {
      if (!counts.containsKey(num)) {
        counts.put(num, 1);
      }
      else {
        counts.put(num, counts.get(num)+1);
      }
    }
    return counts;
  }


  //方法3：排好序后，返回的中间位置的前一个数肯定是众数，因为 长度超过要 n/2
  //Time complexity : O(nlgn)  Space complexity : O(1) or (O(n)
  /*
    If the elements are sorted in monotonically increasing (or decreasing) order,
    the majority element can be found at index flower(n/2) and flower(n/2) +1 ,
    incidentally, if n is even).
  */
  public int majorityElement(int[] nums) {
    Arrays.sort(nums);
    return nums[(nums.length-1)/2];
  }


  //方法4：Divide and Conquer
  //Time complexity : O(nlgn)  Space complexity : O(lgn)

  public int majorityElement(int[] nums) {
    return majorityElementRec(nums, 0, nums.length-1);
  }

  private int countInRange(int[] nums, int num, int lo, int hi) {
    int count = 0;
    for (int i = lo; i <= hi; i++) {
      if (nums[i] == num) {
        count++;
      }
    }
    return count;
  }

  private int majorityElementRec(int[] nums, int lo, int hi) {
    // base case; the only element in an array of size 1 is the majority
    // element.
    if (lo == hi) {
      return nums[lo];
    }

    // recurse on left and right halves of this slice.
    int mid = (hi-lo)/2 + lo;
    int left = majorityElementRec(nums, lo, mid);
    int right = majorityElementRec(nums, mid+1, hi);

    // if the two halves agree on the majority element, return it.
    if (left == right) {
      return left;
    }

    // otherwise, count each element and return the "winner".
    int leftCount = countInRange(nums, left, lo, hi);
    int rightCount = countInRange(nums, right, lo, hi);

    return leftCount > rightCount ? left : right;
  }



  //* 方法5：加注释说明 ，还需再看
  //Time complexity : O(n)  Space complexity : O(1)
  public int majorityElement(int[] nums) {
    int occurs = 0;
    Integer candidate = null;
    for (int num: nums) {
      if (occurs == 0) {
        candidate = num; //出口，表示当 occurs == 0 时，返回 当前值
      }
      occurs += (num == candidate) ? 1 : -1;
    }
    return candidate;
  }

}
