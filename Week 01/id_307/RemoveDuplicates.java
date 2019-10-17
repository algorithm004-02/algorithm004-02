class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int repeatAt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[repeatAt]) {
                if (i != repeatAt) {
                    nums[++repeatAt] = nums[i];
                }
            }
        }
        return nums.length == 0 ? 0 : repeatAt + 1;
    }
}