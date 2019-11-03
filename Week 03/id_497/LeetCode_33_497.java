class Solution {
    public int search(int[] nums, int target) {
        if(nums.length==0) return -1;
        if(nums.length==1) return target == nums[0]?0:-1;
        int index = binarySearchRotated(nums);
        if(target>nums[nums.length-1]) {
            return binarySearch(nums, target,0,index);
        }
        return binarySearch(nums,target,index,nums.length);
    }

    private int binarySearchRotated(int[] nums) {
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
    private int binarySearch(int[] nums,int target,int start,int end) {
        int left = start, right = end-1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid]==target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}