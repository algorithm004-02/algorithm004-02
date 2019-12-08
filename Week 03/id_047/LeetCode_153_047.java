public class LeetCode_153_047 {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (left == right || left + 1 == right) {
                return Math.min(nums[left],nums[right]);
            }
            int mid = left + (right - left) / 2;
            if (nums[mid] >= nums[left]) {
                if (nums[left] > nums[mid + 1] || nums[left] > nums[right]) {
                    left = mid;
                } else {
                    right = mid;
                }
            } else {
                if (nums[mid] > nums[mid + 1]) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }
        return 0;
    }
}
