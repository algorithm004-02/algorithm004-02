package app.homeworkWeekEighth;

/*
 * @lc app=leetcode id=300 lang=java
 *
 * [300] Longest Increasing Subsequence
 *
 * https://leetcode.com/problems/longest-increasing-subsequence/description/
 *
 * algorithms
 * Medium (41.54%)
 * Likes:    3323
 * Dislikes: 75
 * Total Accepted:    288.2K
 * Total Submissions: 690.7K
 * Testcase Example:  '[10,9,2,5,3,7,101,18]'
 *
 * Given an unsorted array of integers, find the length of longest increasing
 * subsequence.
 * 
 * Example:
 * 
 * 
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4 
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore
 * the length is 4. 
 * 
 * Note: 
 * 
 * 
 * There may be more than one LIS combination, it is only necessary for you to
 * return the length.
 * Your algorithm should run in O(n^2) complexity.
 * 
 * 
 * Follow up: Could you improve it to O(n log n) time complexity?
 * 
 */

// @lc code=start
class Solution {
    public int lengthOfLIS(int[] nums) {
        return lengthOfLIS_dp(nums);
    }

    /**
     * 使用动态规划，
     * 状态定义为dp[i],保存最长子序列的最后一个元素为i时的长度
     * 那么设([0]至[i-1]的元素为j)，当j<i时，j都有可能是子序列中的倒数第二个元素，因此我们应该取一个满足条件时最大的子序列
     * 状态方程定义为maxlength=Max(maxlength,dp[j])
     * dp[j] = maxlength + 1;
     * Time O(n^2)
     * Space O(n)
     * @param nums
     * @return
     */
    private int lengthOfLIS_dp(int[] nums) {
        if (nums.length != 0) {
            int [] dp = new int [nums.length];
            dp[0] = 1;
            int maxSequenceLength = 1;
            for (int i = 1; i < dp.length; i++) {
                int maxSubLnegth = 0;
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i]) {
                        maxSubLnegth = Math.max(maxSubLnegth, dp[j]);
                    }
                }
                dp[i] = maxSubLnegth + 1;
                maxSequenceLength = Math.max(maxSequenceLength, dp[i]);
            }
            return maxSequenceLength;
        } 
        return 0;
    }
}
// @lc code=end

