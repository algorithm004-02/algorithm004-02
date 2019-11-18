
/* 
* 题号: 26
* 题目: 删除排序数组中的重复项
* 地址: https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
*/

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 1;
        int j = 1;
        int temp = nums[0];
        for(;i < nums.length;i++){
            if(temp != nums[i]){
                temp = nums[i];
                nums[j++] = temp;
            }
        }
        return j;
    }
}
