class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 0;
        for (int i = 1,len = nums.length ; i < len ; ++ i) {
            if (nums[i] != nums[k]){
                k++;
                nums[k] = nums[i];
            }
        }
        return k + 1;
    }
}
