/*
 * @lc app=leetcode.cn id=189 lang=javascript
 *
 * [189] 旋转数组
 * 解提：
 * 1. 暴力破解
 * 2. 求余数
 */

// @lc code=start
/**
 * 方法一：暴力破解
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotate = function(nums, k) {
    for (let i = 0; i < k; i++) {
      let previous = nums[nums.length - 1]
      for (let j = 0; j < nums.length; j++) {
        let temp = nums[j]
        nums[j] = previous
        previous = temp
      }
    }
};
// @lc code=end

// @lc code=start
/**
 * 方法二：求余数,需要使用额外的数组
 * 
 *  * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */

var rotate = function(nums, k) {
  let temp = []
  for (let i = 0; i < nums.length; i++) {
    temp[(i + k) % nums.length] = nums[i]
  }
  for (let i = 0; i < nums.length; i++) {
      nums[i] = temp[i]
  }
  return nums
}
// @lc code=end

// @lc code=start
/**
 * 方法三：环状替换
 * 
 *  * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */

var rotate = function(nums, k) {
  k = k % nums.length // k超出数组长度
  let count = 0
  for (let i = 0; count < nums.length; i++) {
    let current = i
    let prev = nums[i]
    do {
      let next = (current + k) % nums.length
      let temp = nums[next]
      nums[next] = prev
      prev = temp
      current = next
      count++
    } while (current !== i)
  }
  return nums
}
// @lc code=end
