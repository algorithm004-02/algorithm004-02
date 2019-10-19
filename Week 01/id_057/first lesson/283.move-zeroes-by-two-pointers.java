package app;

/*
 * @lc app=leetcode id=283 lang=java
 *
 * [283] Move Zeroes
 *
 * https://leetcode.com/problems/move-zeroes/description/
 *
 * algorithms
 * Easy (55.37%)
 * Likes:    2456
 * Dislikes: 90
 * Total Accepted:    544.6K
 * Total Submissions: 983.1K
 * Testcase Example:  '[0,1,0,3,12]'
 *
 * Given an array nums, write a function to move all 0's to the end of it while
 * maintaining the relative order of the non-zero elements.
 * 
 * Example:
 * 
 * 
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * 
 * Note:
 * 
 * 
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 * 
 */

// @lc code=start
class Solution {
    /**
     * 利用双指针，记录非0元素的位置，碰到0时交换元素，并更新非0元素位置
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int nonzeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[nonzeroIndex];
                nums[nonzeroIndex] = nums[i];
                nums[i] = temp;
                nonzeroIndex++;
            }
        }
    }
}
// @lc code=end

