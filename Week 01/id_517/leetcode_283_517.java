/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 *
 * https://leetcode-cn.com/problems/move-zeroes/description/
 *
 * algorithms
 * Easy (57.21%)
 * Likes:    414
 * Dislikes: 0
 * Total Accepted:    76K
 * Total Submissions: 132.9K
 * Testcase Example:  '[0,1,0,3,12]'
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 
 * 示例:
 * 
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 
 * 说明:
 * 
 * 
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * 
 * 
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
         planA(nums) ;
    }

    //遇到0就和后面的数字进行交换
    public void planA(int[] nums) {
        int i = 0;
        for(int j = 0;j<nums.length;j++){
            if(nums[j]!=0){
                if(i != j){
                    nums[i] = nums[j];
                    nums[j] = 0;
                }
                i++;
            }
        }
    }

    public void planB(int[] nums) {
        //todo
        //判断非0的数字记录到新数组，同时记录0的次数
        //将新数组拷贝回原来数组，同时补0
        //不清楚此操作是否满足题目要求：
        //必须在原数组上操作，不能拷贝额外的数组。
    }
}
// @lc code=end

