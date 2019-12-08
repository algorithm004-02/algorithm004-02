package algorithm.LeetCode;

/**
 * describe:
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 *
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 *
 * @author lixilong
 * @date 2019/11/03
 */
public class _33_Search {


  public int search(int[] nums, int target) {
    int lo = 0, hi = nums.length - 1;
    while (lo < hi) {
      int mid = (lo + hi) / 2;
      if ((nums[0] > target) ^ (nums[0] > nums[mid]) ^ (target > nums[mid]))   //先用真值表判断各种 case,后改为异或表达式来判断
        lo = mid + 1;
      else
        hi = mid;
    }
    return lo == hi && nums[lo] == target ? lo : -1;
  }
}
