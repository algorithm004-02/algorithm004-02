class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int other = target - nums[i];
            for (int j=i+1;j<nums.length;j++) {
                if(other == nums[j]) {
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }
}
