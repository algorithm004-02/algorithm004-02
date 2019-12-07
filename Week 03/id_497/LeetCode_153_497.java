class Solution {
    public int findMin(int[] nums) {
        if(nums.length==0) return -1;
        if(nums.length==1) return nums[0];
        int index = binarySearchMin(nums);
        return nums[index];
    }

    private int binarySearchMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right)+1 / 2;
            if (nums[mid] < nums[mid - 1]) {
                return mid;
            } else if (nums[mid] > nums[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return 0;
    }
}