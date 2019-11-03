/**
 * 
 * 提解：
 * 1. 在忽略不使用额外的数组空间这个条件下，可以循环数组，将不重复的内容添加在新数组中
 * 2. 双指针法
 */

/*
 * @lc app=leetcode.cn id=26 lang=javascript
 *
 * [26] 删除排序数组中的重复项
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function(nums) {
  let i = 0
  let len = nums.length
  for (let j = 1; j < len; j++) {
    if (nums[i] !== nums[j]) {
      i++
      nums[i] = nums[j]
    }
  }
  return i + 1
};
// @lc code=end

