package app;
/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

// @lc code=start
class Solution {
    /**
     * 暴力法双指针求解
     * 时间复杂度O(n^2)
     * 空间复杂度O(n)
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i+1; j< numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }
}
// @lc code=end

