
/* 
* 题号: 189
* 题目: 旋转数组
* 地址: https://leetcode-cn.com/problems/rotate-array/
*/

class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length -1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    public void reverse(int[] nums,int start,int end) {
        while(start < end){
            int temp = nums[end];
            nums[end--] = nums[start];
            nums[start++] = temp;
        }
    }
}
