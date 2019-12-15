/** 300. 最长上升子序列 **/

// 1. 动态规划
// 2. 动态规划 + 二分查找

/**
 * 1. 动态规划 
 * 时间复杂度O(n^2) 空间复杂度O(n)
 * @param {number[]} nums
 * @return {number}
 */
var lengthOfLIS = function(nums) {
    let len = nums.length;
    if (len === 0) return 0;
    
    let dp = Array(len).fill(1);

    for (let i = 0; i < nums.length; i ++) {
        let num = nums[i];
        for(let j = 0; j < i; j ++) {
            if (nums[j] < nums[i]) {
                dp[i] = Math.max(dp[i], dp[j] + 1)
            }
        }
    }

    return Math.max(...dp);
};

/**
 * 2. dp + 
 * 时间复杂度O(nlogn) 空间复杂度O(n)
 * @param {number[]} nums
 * @return {number}
 */
var lengthOfLIS = function(nums) {
    let len = nums.length;
    if (len === 0) return 0;
    
    let tails = [];
    for (let i = 0; i < nums.length; i ++) {
        let num = nums[i];

        let l = 0;
        let r = tails.length;

        while(l < r) {
            let m = (l + r) >> 1;
            if (tails[m] < num) {
                l = m + 1;
            } else {
                r = m;
            } 
        }

        tails[l] = num;
    }

    return tails.length;
};