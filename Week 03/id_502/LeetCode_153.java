class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        
        int mid = nums.length/2;
        if(nums.length <= (mid + 1)) {
            //<=两个
            if (nums[mid] > nums[mid - 1]) {
                return nums[mid - 1];
            }
            return nums[mid];
        } else {
            //直接是一个有序数组
            if ((nums[mid] > nums[mid - 1]) 
                && nums[mid] < nums[mid + 1]
                && nums[mid] > nums[mid - 1]) {
                return nums[0];
            } else {
                
            }
            return nums[mid];
        }
    }
}