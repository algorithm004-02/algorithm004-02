/**
1. 暴力
2. DP：
    a. 分治（子问题)
        res = [number[i], number[i] * a[i - 1][0], number[i] * a[i - 1][1]]
        a[i] = [Min(res), Max(res)]
    b. 状态数组定义 f[i] = [minVal, maxVal]
    c. DP方程 
         res = [number[i], number[i] * f[i - 1][0], number[i] * f[i - 1][1]]
         f[i] = [Min(res), Max(res);
 */

/**
 * @param {number[]} nums
 * @return {number}
 */
var maxProduct = function(nums) {
    let dpMin = 1;
    let dpMax = 1;
    let max = - Number.POSITIVE_INFINITY;

    for (let i = 0; i < nums.length; i ++) {
        let res = [nums[i], nums[i] * dpMin, nums[i] * dpMax];
        dpMin = Math.min(...res);
        dpMax = Math.max(...res);
        
        max = Math.max(dpMax, max);
    }

    return max;
};
