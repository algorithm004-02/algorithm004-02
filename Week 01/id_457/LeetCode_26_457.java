class Solution {
    //数组为排序数组，若有重复元素，这些元素必定彼此相邻
    //双指针法
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {  //相邻两个元素不相等
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }
}