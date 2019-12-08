/*
 * @lc app=leetcode.cn id=198 lang=javascript
 *
 * [198] 打家劫舍
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function(nums) {
  let pre = 0
  let curr = 0
  for (let i = 0; i < nums.length; i++) {
    let temp = curr
    curr = Math.max(pre + nums[i], curr)
    pre = temp
  }
  return curr
};
// @lc code=end

