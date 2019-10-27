
//使用双指针的思想，一个指针标记需要对比的元素，一个指正进行遍历、
class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 0;//需要进行比较的指针
        for (int i = 0; i < nums.length; i++) {// i 模拟循环指针
            if(nums[i] != nums[index]){
                nums[++index] = nums[i];
            }
        }
        return index + 1;
    }
}