/*
 * @lc app=leetcode.cn id=42 lang=javascript
 *
 * [42] 接雨水
 */

// @lc code=start
/**
 * @param {number[]} height
 * @return {number}
 */
// 方法一：暴力求解
var trap = function (height) {
  let result = 0;
  for (let i = 1; i < height.length - 1; i++) {
    let maxLeft = 0, maxRight = 0;
    for (let j = i; j >= 0; j--) {
      maxLeft = Math.max(maxLeft, height[j]);
    }

    for (let j = i; j < height.length; j++) {
      maxRight = Math.max(maxRight, height[j]);
    }

    result += Math.min(maxLeft, maxRight) - height[i];
  }

  return result;
};
// @lc code=end