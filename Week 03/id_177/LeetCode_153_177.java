package week03;

/*
153. 寻找旋转排序数组中的最小值

假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

请找出其中最小的元素。

你可以假设数组中不存在重复元素。

示例 1:

    输入: [3,4,5,1,2]
    输出: 1

示例 2:

    输入: [4,5,6,7,0,1,2]
    输出: 0

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * @author Will WM. Zhang
 * @since 2019-10-30 15:01
 */

public class LeetCode_153_177 {

    public static void main(String[] args) {
        LeetCode_153_177 test = new LeetCode_153_177();

        int[] nums = {3, 4, 5, 1, 2};

        int result = test.findMin(nums);

        System.out.println("result: " + result);
    }

    private int findMin(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        if (nums.length == 1)
            return nums[0];

        int left = 0, right = nums.length - 1;

        if (nums[right] > nums[left])
            return nums[0];

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[mid + 1])
                return nums[mid + 1];

            if (nums[mid - 1] > nums[mid])
                return nums[mid];

            if (nums[mid] > nums[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
