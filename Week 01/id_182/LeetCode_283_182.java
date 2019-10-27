
/* 
* 题号: 283
* 题目: 移动零
* 地址: https://leetcode-cn.com/problems/move-zeroes
*/

class Solution {
    public void moveZeroes(int[] nums) {
        int current = 0;
        int next = 0;
        while(next < nums.length){
            if(nums[next] == 0){
                next++;
            }else{
                nums[current++] = nums[next++];
            }
        }
        while(current < nums.length){
            nums[current++] = 0;
        }
    }
}
