public class Solution {
	public int findMin(int[] nums) {
		if(null == nums || nums.length == 0) {
			return 0;
		}
		if(nums.length == 1) {
			return nums[0];
		}
		int start = 0;
		int end = nums.length - 1;
		while(start < end) {
			int mid = start + (end-start)/2;
			if(mid > 0 && nums[mid] < nums[mid-1]) {
				return nums[mid];
			}
			if(nums[mid] >= nums[start] && nums[mid] > nums[end]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return nums[start];
        
    }
}