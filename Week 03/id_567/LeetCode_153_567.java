/*
 * @lc app=leetcode.cn id=153 lang=java
 *
 * [153] 寻找旋转排序数组中的最小值
 *
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/description/
 *
 * algorithms
 * Medium (49.78%)
 * Likes:    102
 * Dislikes: 0
 * Total Accepted:    21K
 * Total Submissions: 42.2K
 * Testcase Example:  '[3,4,5,1,2]'
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * 
 * ( 例如，数组 [0,1,2,4,5,6,7]  可能变为 [4,5,6,7,0,1,2] )。
 * 
 * 请找出其中最小的元素。
 * 
 * 你可以假设数组中不存在重复元素。
 * 
 * 示例 1:
 * 
 * 输入: [3,4,5,1,2]
 * 输出: 1
 * 
 * 示例 2:
 * 
 * 输入: [4,5,6,7,0,1,2]
 * 输出: 0
 * 
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        // 边界条件
        if (nums == null || nums.length == 0)
            return Integer.MIN_VALUE;

        // 二分，顺序的一边不要，在非顺序的一边继续二分
        int low = 0, high = nums.length - 1;
        while (low < high - 1) {
            int mid = (low + high) / 2;
            if (nums[low] <= nums[mid] && nums[mid] > nums[high]) {
                low = mid;
            } else {
                high = mid;
            }
        }
        if (nums[low] <= nums[high]) {
            return nums[low];
        }
        return nums[high];
    }
}
// @lc code=end
