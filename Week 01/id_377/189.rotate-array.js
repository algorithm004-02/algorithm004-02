// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotate = function(nums, k) {
    // ------------------------- 解法1 start --------------------------
    // 最好记  👍 👍 👍 👍 👍
    // 最优解  😘 😘 😘 😘 😘
    nums.unshift(...nums.splice(nums.length - k));
    // nums.unshift(...nums.splice(nums.length-k, k))

    // ------------------------- 解法2 start --------------------------
    // 最好记  👍 👍 👍 👍
    // 最优解  😘 😘 😘 😘
    // for (let i = 0; i < k; i++) {
    //     nums.unshift(nums.pop());
    // }

    // ------------------------- 解法3 start --------------------------
    // 最好记  👍 👍 👍
    // 最优解  😘 😘 😘 😘
    // nums.splice(0,0,...nums.splice(nums.length-k, k))
    
};
// @lc code=end

console.log(
    rotate([1,2,3,4,5,6,7],3)
);


