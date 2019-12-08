package app.homeworkWeekFifth;

/*
 * @lc app=leetcode id=198 lang=java
 *
 * [198] House Robber
 *
 * https://leetcode.com/problems/house-robber/description/
 *
 * algorithms
 * Easy (41.38%)
 * Likes:    3253
 * Dislikes: 112
 * Total Accepted:    394.6K
 * Total Submissions: 952.2K
 * Testcase Example:  '[1,2,3,1]'
 *
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed, the only constraint stopping
 * you from robbing each of them is that adjacent houses have security system
 * connected and it will automatically contact the police if two adjacent
 * houses were broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight
 * without alerting the police.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money =
 * 3).
 * Total amount you can rob = 1 + 3 = 4.
 * 
 * Example 2:
 * 
 * 
 * Input: [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house
 * 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 * 
 * 
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        return rob_max(nums);
    }

    /**
     * 动态规划，
     * 定义为，第n天偷的最大值，那么有dp[n] = MAX( dp[n-1], dp[n-2] + num );
     * 最后求数组中的最大值
     * time O(n)
     * space O(n)
     * @param nums
     * @return
     */
    private int rob_max(int[] nums) {
        if (nums.length < 1) return 0;
        if (nums.length == 1) return nums[0];
        int [] dp = new int [nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] , dp[i - 2] + nums[i - 1]);
        }
        return dp[nums.length];
    }

    /**
     * 动态规划 
     * 重复子问题， 
     * 第n间不偷，那么最大简直为nums[n-1]偷或不同的最大值 
     * 第n间偷，那么最大价值为nums[n] +
     * nums[n-1]不同的最大值 dp[n][0] = max(dp[n-1][0], dp[n-1][1]); dp[n][1] = dp[n-1][0]
     * + nums[n]; 然后求二维数组的最大值
     * time O(n)
     * space O(n)
     * @param nums
     * @return
     */
    private int rob_matrix(int[] nums) {
        if (nums.length < 1) return 0;
        int n = nums.length;
        int [][] dp = new int [n][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }
}
// @lc code=end

