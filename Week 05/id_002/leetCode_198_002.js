/** 198. 打家劫舍 **/

// DP:
//    a. 分治（子问题）
//        a[i] = [a[i - 1][1] + nums[i], Max(a[i - 1][0], a[i - 1][1])]
//    b. 状态数组
//          f[i] = [0, 1] 0:偷 1:不偷
//    c. DP方程
//          f[i] = [a[i - 1][1] + nums[i], Max(a[i - 1][0], a[i - 1][1])]

/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function(nums) {
    let len  = nums.length;
    let dp = Array(len);

    if (len === 0) return 0;

    if (len === 1) return nums[0];

    dp[0] = [nums[0], 0];
    for (let i = 1; i < nums.length; i ++) {
        dp[i] = [dp[i - 1][1] + nums[i], Math.max(dp[i - 1][0], dp[i - 1][1])];
    }

    return Math.max(dp[len - 1][0], dp[len - 1][1]);
};

/**
 * dp数组变成一维数组
 * @param {number[]} nums
 * @return {number}
 */
var rob = function(nums) {
    let len  = nums.length;
    if (len === 0) return 0;

    if (len === 1) return nums[0];

    let dp = Array(len);
    dp[0] = nums[0];
    dp[1] = Math.max(nums[0], nums[1]);
    
    for (let i = 2; i < nums.length; i ++) {
        dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
    }

    return dp[len - 1];
};

/**
 * 一维度dp数组 在优化
 * @param {number[]} nums
 * @return {number}
 */
var rob3 = function(nums) {
    let prevMax = 0;
    let curMax = 0;
    
    for (let i = 0; i < nums.length; i ++) {
        let tmp = curMax;
        curMax = Math.max(prevMax + nums[i], curMax);
        prevMax = tmp;
    }

    return curMax;
};