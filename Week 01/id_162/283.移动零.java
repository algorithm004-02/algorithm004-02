/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        int i0 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i0 != i) {
                    nums[i0] = nums[i];    
                }
                i0++;
            }
        }
        for (int i = i0; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
// @lc code=end

