
/*** 53. 最大子序和 **/

/**
 * DP
 * @param {number[]} nums
 * @return {number}
 */
var maxSubArray = function(nums) {
    /**
      1. 暴力解法
      2. DP:
        a. 分治（子问题): max_sum(i) = Max(max_sum(i - 1), 0) + a[i] 
        b. 状态数组: f[i]
        c. dp方程: f[i] = Max(f[i - 1], 0) + a[i];
    */
    
    for(let i = 1; i < nums.length; i ++) {
        nums[i] = Math.max(nums[i - 1], 0) + nums[i];
    }

    return Math.max(...nums);
};