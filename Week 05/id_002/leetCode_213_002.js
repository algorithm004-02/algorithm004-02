/** 213. 打家劫舍 II **/

// DP: 
//      a. 分治子问题
//          a[n] = [a[n - 1][1] + nums[i], Max(a[n - 1][0], a[n - 1][1])]
//      b. 状态数组
//          f[:1] = [0, 1]
//          f[n - 1:] = [0, 1]
//          0: 偷
//          1: 不偷
//      c. DP方程
//          f[:1], f[:n - 1]
//          f[n] = [nums[i] + f[n - 1][1], Max(a[n - 1][0], a[n - 1][1])]

/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function(nums) {
    let len = nums.length;
    if (len === 0) return 0;
    if (len === 1) return nums[0];

    return Math.max(my_rob(nums.slice(1)), my_rob(nums.slice(0, len - 1)));

    function my_rob(nums) {
        let dp = Array(nums.length);
        dp[0] = [nums[0], 0];
        for(let i = 1; i < nums.length; i++) {
            dp[i] = [nums[i] + dp[i - 1][1], Math.max(dp[i - 1][0], dp[i - 1][1])];
        }

        let len = nums.length;
        return Math.max(dp[len - 1][0], dp[len - 1][1]);
    }
};

/**
 * 降维度
 * @param {number[]} nums
 * @return {number}
 */
var rob2 = function(nums) {
    let len = nums.length;
    if (len === 0) return 0;
    if (len === 1) return nums[0];

    return Math.max(my_rob(nums.slice(1)), my_rob(nums.slice(0, len - 1)));

    function my_rob(nums) {
        let dp = Array(nums.length);
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(let i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }

        let len = nums.length;
        return dp[len - 1];
    }
};

/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function(nums) {
    let len = nums.length;
    if (len === 0) return 0;
    if (len === 1) return nums[0];

    return Math.max(my_rob(nums.slice(1)), my_rob(nums.slice(0, len - 1)));

    function my_rob(nums) {
        let prev = 0;
        let cur = 0;

        for(let i = 0; i < nums.length; i++) {
            let tmp = cur;
            cur = Math.max(nums[i] + prev, cur);
            prev = tmp;
        }

        return cur;
    }
};