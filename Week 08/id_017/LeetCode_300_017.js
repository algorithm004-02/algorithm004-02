/*
 * @lc app=leetcode.cn id=300 lang=javascript
 *
 * [300] 最长上升子序列
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var lengthOfLIS = function(nums) {
    let n = nums.length;
    if(n == 0) return 0;
    let dp = new Array(n).fill(1);
    let max = 0;
    for(let i = 0; i < n; i++) {
        for(let j = 0; j < i; j++) {
            if(nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
        }
        max = Math.max(max,dp[i]);
    }
    return max;
};
