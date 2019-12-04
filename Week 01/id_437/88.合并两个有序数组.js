/*
 * @lc app=leetcode.cn id=88 lang=javascript
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
/**
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 */
var merge = function(nums1, m, nums2, n) {
  let n1 = 0, n2 = 0, nums = []
  for (let i = 0; i < m; i++) {
    nums[i] = nums1[i]
  }
  for (let i = 0; i < m + n; i++) {
    if (n1 >= m || nums[n1] > nums2[n2]) {
      nums1[i] = nums2[n2]
      n2++
    } else {
      nums1[i] = nums[n1]
      n1++
    }
  }
};
// @lc code=end

// @lc code=start
/**
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 */
var merge = function(nums1, m, nums2, n) {
  let i = m -1, j = n - 1, tar = m + n - 1
  while (j >= 0) {
    nums1[tar--] = i >= 0 && nums1[i] > nums2[j] ? nums1[i--] : nums2[j--]
  }
};
// @lc code=end

