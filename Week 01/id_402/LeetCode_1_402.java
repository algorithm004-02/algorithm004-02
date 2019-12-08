class Solution {
    public int[] twoSum(int[] nums, int target) {
       int[] result = new int[2];
        for(int i = 0;i < nums.length -1; i ++ ){
            boolean flag = false;
            for(int j=i+1; j<nums.length; j++){
                if(nums[i]+nums[j] == target){
                    result[0] = i;result[1] = j;
                    flag = true;
                    break;
                }
                if(flag){
                    break;
                }
            }
        }
        return result;
    }
}