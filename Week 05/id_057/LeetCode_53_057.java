package app.homeworkWeekFifth;
import java.util.Arrays;

/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 *
 * https://leetcode.com/problems/maximum-subarray/description/
 *
 * algorithms
 * Easy (44.81%)
 * Likes:    5499
 * Dislikes: 234
 * Total Accepted:    688K
 * Total Submissions: 1.5M
 * Testcase Example:  '[-2,1,-3,4,-1,2,1,-5,4]'
 *
 * Given an integer array nums, find the contiguous subarray (containing at
 * least one number) which has the largest sum and return its sum.
 * 
 * Example:
 * 
 * 
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * 
 * 
 * Follow up:
 * 
 * If you have figured out the O(n) solution, try coding another solution using
 * the divide and conquer approach, which is more subtle.
 * 
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        return maxSubArray_dp(nums);
    }

    /**
     * dp定义，当nums[i]为子序列的最后一个元素时，那么最大的序列和有两种情况，
     * 1，子序列中只有nums[i]一个元素，
     * 2，子序列中除了nums[i],还包含以nums[i-1]为最后一个元素的子序列
     * 因此dp方程为dp[i] = max(nums[i], nums[i] + dp[i - 1])
     * 初始定义dp和nums相同
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     * @param nums
     * @return
     */
    private int maxSubArray_dp(int[] nums) {
        int [] dp = Arrays.copyOf(nums, nums.length);
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
// @lc code=end

