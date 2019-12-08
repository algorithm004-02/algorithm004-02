class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length==0||(nums[0]==0&&nums.length>1)) return false;
        return isJump(nums,nums.length-1);
    }

    public boolean isJump(int[] nums, int target){
        if(target<1) {
            return true;
        }
        for (int i = 0; i < target ; i++) {
            if(nums[i]>=(target-i)){
                return isJump(nums,i);
            }
        }
        return false;
    }
}