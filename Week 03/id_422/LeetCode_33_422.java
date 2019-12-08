class Solution {

    public int search(int[] nums, int target) {

        int lenght = nums.length;
        int left = 0;
        int right = lenght -1;

        while(left <= right){
            //找到中间角标
            int mid = (left + right) / 2;

            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < nums[right]){
                if(nums[mid] < target && target <= nums[right]){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }else{
                if(nums[left] <= target && target < nums[mid]){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }
        }

        return -1;
    }
}