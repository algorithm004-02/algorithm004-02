class Solution {
    public void moveZeroes(int[] nums) {

        int tmpIndex = 0;
        for (int i = 0; i <nums.length ; i++) {
            if (nums[i] != 0){
                if (i > tmpIndex){
                    nums[tmpIndex] = nums[i];
                    nums[i] = 0;
                }
                tmpIndex ++;
            }

        }
    }
}
