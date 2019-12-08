class Solution {
    public int findMin(int[] nums) {
        
        if (nums.length == 1) {
            return nums[0];
        }
        
        int left = 0;
        
        int right = nums.length - 1;
        
        while (left < right) {
            
            //U must check the left < right.
            
            if (nums[left]< nums[right])
                return nums[left];
            
            //
            
            int mid = (left + right ) >> 1;
            
            if (nums[mid] >= nums[left]) {
                left = mid + 1; 
            } else  {
                right = mid  ;
            }
        }
        
        return nums[left];
        
        
        
    }
}