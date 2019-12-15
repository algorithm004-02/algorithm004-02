/*
 * @lc app=leetcode id=26 lang=java
 *
 * [26] Remove Duplicates from Sorted Array
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return 1;

        int position = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[position - 1]) {
                nums[position++] = nums[i];
            }
        }
        return position;

    }
}
// @lc code=end
