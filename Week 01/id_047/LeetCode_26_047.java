class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int diffCount = nums.length;
        for (int i = 0; i < nums.length; i++) {
            for (int j = diffCount - 1; j > i ; j --) {
                if (nums[i] == nums[j]) {
                    diffCount -= 1;
                    for (int k = j; k < diffCount; k++) {
                        int temp = nums[k];
                        nums[k] = nums[k + 1];
                        nums[k + 1] = temp;
                    }
                }
            }
        }
        return diffCount;
    }
}