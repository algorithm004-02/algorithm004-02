class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i<nums.length; i++) {
            if (nums[i] != 0 ) {
                ++j;
                if (i > j-1) {
                    nums[j-1] = nums[i];
                    nums[i]=0;
                }
            }
        }
    }
}