/**
     * 半有序数组,两个有序数组组成。如果查找到目标值,返回下标 https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
     *
     * @param nums   [4,5,6,7,0,1,2]
     * @param target 目标值
     * @return 下标
     */
    public static int search(int[] nums, int target) {
        int left = nums[0];
        int right = nums[nums.length - 1];
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] > nums[left]) {
                // left is sorted
                if (target > nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }

            }
        }
        return -1;
    }