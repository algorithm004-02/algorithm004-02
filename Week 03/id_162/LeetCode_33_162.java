class Solution {
    public int search(int[] nums, int target) {

        int l = 0;
        int r = nums.length - 1;
        int mid = 0;
        while (l < r) {

            mid = (l + r) / 2;

            if (nums[mid] == target) {
                return mid;

                //左边单调 && 在右边
            } else if (nums[mid] >= nums[l] && (target > nums[mid] || target < nums[l])) {
                l = mid + 1;

                // 右边单调 && 在右边
            } else if (nums[mid] < nums[r] && nums[mid] <= target && target <= nums[r]) {
                l = mid + 1;

                // 都在左边
            } else {
                r = mid;
            }
        }

        return l == r && nums[l] == target ? l : -1;
    }
}