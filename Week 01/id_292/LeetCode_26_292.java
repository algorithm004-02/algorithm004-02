 /**
     * 删除数组中的冲元素
     *
     * @param nums 有序数组
     * @return 数组大小
     */
    public static int removeDuplicateNumbers(int[] nums) {
        int i = 0;
        for (int index = 1; index < nums.length; index++) {
            if (nums[i] != nums[index]) {
                i++;
                nums[i] = nums[index];
            }
        }
        return i + 1;
    }