/**
 * @param {number[]} nums
 * @return {number}
 */
var maxProduct = function(nums) {
    let max = - Number.POSITIVE_INFINITY;
    let dpMax = 1;
    let dpMin = 1;

    for (let i = 0; i < nums.length; i++) {
        if (nums[i] < 0) [dpMax, dpMin] = [dpMin, dpMax];

        dpMax = Math.max(dpMax * nums[i], nums[i]);
        dpMin = Math.min(dpMin * nums[i], nums[i]);

        max = Math.max(dpMax, max);
    }

    return max;
};
