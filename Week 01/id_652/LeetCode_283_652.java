class Solution {
    //方法1：将所有的非零元素都填充到数组前侧，然后将0填充到数组后侧。本质其实就是双指针法
    public void moveZeroes(int[] nums) {
        int lastNotZeroIndex = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                nums[lastNotZeroIndex++] = nums[i];
            }
        }
        
        for (int i = lastNotZeroIndex; i < nums.length; ++i) {
            nums[i] = 0;
        }
    }
    
    //方法2：用 j 记录上一个可能为0的值的索引，用 i 遍历数组，当遇到不为0的值的时候，将该元素 
    //num[i] 与 nums[j] 交换，保证 j 前面的元素均为非0值。本质其实就是双指针法
    public void moveZeroes1(int[] nums) {
        int lastZeroIndex = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[lastZeroIndex];
                nums[lastZeroIndex] = temp;
                lastZeroIndex++;
            }
        }
    }
}
