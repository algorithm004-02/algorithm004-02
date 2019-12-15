class Solution {
    int result = 0;
    boolean back =false;
    public int jump(int[] nums) {
        if(nums.length==0||(nums[0]==0&&nums.length>1)) return 0;
        isJump(nums,nums.length-1,0);
        return result;
    }

    public void isJump(int[] nums, int target,int count){

        if(target<1) {
            result = count;
            back = true;
        }
        for (int i = 0; i < target ; i++) {
            if(nums[i]>=(target-i)){
                count++;
                isJump(nums,i,count);
                if(back){
                    break;
                }
                count--;
            }
        }
    }
}