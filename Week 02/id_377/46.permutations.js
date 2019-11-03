/*
 * @lc app=leetcode id=46 lang=javascript
 * 
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
// ------------------------- 解法 1 start --------------------------
// 最好记  👍 👍 👍 👍 👍
// 最优解  😘 😘 😘 😘
// var permute = function(nums) {
//     const res = [];
//     backtrack(nums, res);
//     return res;
// };

// function backtrack(nums, res, n = 0) {
//     if (n === nums.length - 1) {
//         res.push(nums.slice(0));
//         return;
//     }
//     for (let i = n; i < nums.length; i++) {
//         [nums[i], nums[n]] = [nums[n], nums[i]];
//         backtrack(nums, res, n + 1);
//         [nums[i], nums[n]] = [nums[n], nums[i]];
//     }
// }

// ------------------------- 解法 2 start --------------------------
// 最好记  👍 👍 👍 👍
// 最优解  😘 😘 😘 😘
// const helper = function(tmp, inp, outp) {
//     if (inp.length == 0) {
//         outp.push(tmp.slice())
//         return
//     }
//     for (let i = 0; i < inp.length; i++) {
//         tmp.push(inp[i])
//         inp.splice(i, 1)
//         helper(tmp, inp, outp)
//         inp.splice(i, 0, tmp.pop())
//     }
// }

// var permute = function(nums) {
//     let tmp = [], outp = []
//     helper(tmp, nums, outp)
//     return outp
// };

// ------------------------- 解法 2 start --------------------------
// 最好记  👍 👍 👍 👍
// 最优解  😘 😘 😘
var permute = function(nums, n = 0) {
    if (n >= nums.length) return [[]];
    const res = [];
    const prevs = permute(nums, n + 1);
    for (let prev of prevs) {
        for (let i = 0; i <= prev.length; i++) {
            let p = prev.slice(0);
            p.splice(i, 0, nums[n]);
            res.push(p);
        }
    }
    return res;
};



// @lc code=end

