class Solution {
    public void moveZeroes(int[] nums) {
        int lastNoneEero =0;
        for (int i=0 ;i< nums.length;i++) {
            if (nums[i]!=0) {
                nums[lastNoneEero] = nums[i];
                if(i!=lastNoneEero) {
                    nums[i]=0;
                }
                lastNoneEero++;
            }
        }
    }
}