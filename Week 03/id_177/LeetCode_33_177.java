package week03;

/*
33. 搜索旋转排序数组

假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

你可以假设数组中不存在重复的元素。

你的算法时间复杂度必须是 O(leftg n) 级别。

示例 1:

    输入: nums = [4,5,6,7,0,1,2], target = 0
    输出: 4

示例 2:

    输入: nums = [4,5,6,7,0,1,2], target = 3
    输出: -1

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * @author Will WM. Zhang
 * @since 2019-10-30 14:48
 */
public class LeetCode_33_177 {

    public static void main(String[] args) {
        LeetCode_33_177 test = new LeetCode_33_177();

        int[] nums = {2, 3, 4, 5, 6, 7, 0, 1};
        int target = 5;

        System.out.println(test.search(nums, target));
    }

    private int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[0] <= nums[mid] && (target > nums[mid] || target < nums[0])) {
                left = mid + 1;
            } else if (target > nums[mid] && target < nums[0]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left == right && nums[left] == target ? left : -1;
    }

}
