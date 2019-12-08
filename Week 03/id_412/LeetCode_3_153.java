package Week03.Chapter11;

public class LeetCode_3_153 {
    //https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
    // [4,5,6,7,0,1,2]
    // [7,0,1,2,4,5,6]
    // [5,6,7,0,1,2,4]
    private int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int left = 0, right = nums.length - 1;

        if (nums[right] >= nums[0]) {
            return nums[0];
        }

        while (right > left) {
            int mid = (right + left)/ 2;
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }

            if (nums[mid] > nums[left]) {
                // 往右边找
                left = mid + 1;
            } else {
                // 往左边找
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        final int[] nums = {7,0,1,2,4,5,6};
        final LeetCode_3_153 test = new LeetCode_3_153();
        System.out.println(test.findMin(nums));
    }
}
