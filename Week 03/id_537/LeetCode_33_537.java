package leetcode.editor.cn;

//假设按照升序排序的数组在预先未知的某个点上进行了旋转。
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。 
//
// 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。 
//
// 你可以假设数组中不存在重复的元素。 
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 示例 1: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 0
//输出: 4
// 
//
// 示例 2: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 3
//输出: -1 
// Related Topics 数组 二分查找
public class LeetCode_33_537 {

    public static void main(String[] args) {
        Solution solution = new LeetCode_33_537().new Solution();
        int[] nums = new int[]{1,3};
        solution.search(nums, 3);
    }

    private

//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {

            if (nums == null || nums.length == 0) {
                return -1;
            }
            if (nums.length == 1) {
                return nums[0] == target ? 0 : -1;
            }
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return mid;
                }
                if (nums[mid] > nums[right] && nums[mid] > target && nums[left] <= target) {
                    right = mid;
                } else if (nums[mid] < nums[right] && (nums[mid] > target || nums[right] < target)) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return -1;


            /**
             * 找出旋转点后进行二分查找的解法
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] > nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (target > nums[nums.length - 1]) {
                left = 0;
            } else {
                right = nums.length - 1;
            }

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return -1;
            */
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}