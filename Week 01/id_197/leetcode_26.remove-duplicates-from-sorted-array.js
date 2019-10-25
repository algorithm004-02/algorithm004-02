/*
 * @lc app=leetcode id=26 lang=javascript
 *
 * [26] Remove Duplicates from Sorted Array
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
// 想到的方法是双指针法，一个记录当前的无重复，一个不断向后遍历数组直到最后一个元素；
// 平常面试题里面可能想new Set再array方法，或者用hash map的方法
let removeDuplicates = function(nums) {
    // 设置双指针
    let i = 0;
    let j = 0;
    for (j; j < nums.length; j++) {
        if (nums[i] !== nums[j]) {
            nums[++i] = nums[j];
        }
    }
    return i+1;
};
// @lc code=end