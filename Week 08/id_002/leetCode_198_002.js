/** 198. 打家劫舍 **/

// DP
//      a. 分治
//          f[i] = [f[i - 1][1] + nums[i], max(f[i - 1][0], f[i - 1][1])]
//      b. 状态数组
//          dp[i] = [0, 1] 0: 偷 1：不偷
//      c. DP方程
//          dp[i] = [f[i - 1][1] + nums[i], max(dp[i - 1][0], dp[i - 1][1])] 

/**
 * 1. dp
 * 时间复杂度为O(n) 空间复杂度O(n)
 * @param {number[]} nums
 * @return {number}
 */
var rob = function(nums) {
    let len = nums.length;

    if(len === 0) return 0;
    
    let dp = [[nums[0], 0]];

    for(let i = 1; i < len; i ++) {
        dp[i] = [dp[i - 1][1] + nums[i], Math.max(dp[i - 1][0], dp[i - 1][1])];
    }

    return Math.max(...dp[len - 1]);
};

/**
 * dp 状态压缩
 * 时间复杂度为O(n) 空间复杂度O(1)
 * @param {number[]} nums
 * @return {number}
 */
var rob = function(nums) {
    let len = nums.length;

    if(len === 0) return 0;

    let dp = [nums[0], 0];

    for(let i = 1; i < len; i ++) {
        dp = [dp[1] + nums[i], Math.max(dp[0], dp[1])];
    }

    return Math.max(...dp);
};

