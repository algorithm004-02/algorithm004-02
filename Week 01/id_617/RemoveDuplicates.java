class RemoveDuplicates {
    /**
     * 给定一个排序数组，你需要在原地删除重复出现的元素，
     * 使得每个元素只出现一次，返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        // 当数组长度为0时直接返回
        if (nums.length == 0) return 0;
        // 定义记录元素个数的变量k，并且也作为数组下标
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            // 每当数组中有数字与前一个数字不同时，则说明为新数字
            if (nums[i] != nums[i - 1]) {
                // 将该数字移动至k处，并将k的值加1。
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}