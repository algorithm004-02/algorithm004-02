/*
 * @lc app=leetcode id=26 lang=javascript
 *
 * [26] Remove Duplicates from Sorted Array
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 *
 * algorithms
 * Easy (42.18%)
 * Likes:    1777
 * Dislikes: 3852
 * Total Accepted:    712.8K
 * Total Submissions: 1.7M
 * Testcase Example:  '[1,1,2]'
 *
 * Given a sorted array nums, remove the duplicates in-place such that each
 * element appear only once and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this by modifying
 * the input array in-place with O(1) extra memory.
 * 
 * Example 1:
 * 
 * 
 * Given nums = [1,1,2],
 * 
 * Your function should return length = 2, with the first two elements of nums
 * being 1 and 2 respectively.
 * 
 * It doesn't matter what you leave beyond the returned length.
 * 
 * Example 2:
 * 
 * 
 * Given nums = [0,0,1,1,1,2,2,3,3,4],
 * 
 * Your function should return length = 5, with the first five elements of nums
 * being modified to 0, 1, 2, 3, and 4 respectively.
 * 
 * It doesn't matter what values are set beyond the returned length.
 * 
 * 
 * Clarification:
 * 
 * Confused why the returned value is an integer but your answer is an array?
 * 
 * Note that the input array is passed in by reference, which means
 * modification to the input array will be known to the caller as well.
 * 
 * Internally you can think of this:
 * 
 * 
 * // nums is passed in by reference. (i.e., without making a copy)
 * int len = removeDuplicates(nums);
 * 
 * // any modification to nums in your function would be known by the caller.
 * // using the length returned by your function, it prints the first len
 * elements.
 * for (int i = 0; i < len; i++) {
 * print(nums[i]);
 * }
 * 
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function (nums) {
    if (nums.length === 0) {
        return 0;
    }

    // ------------------------- 解法1 start --------------------------
    // 最好记  👍 👍 👍
    // 最优解  😘 😘 😘 😘 😘
    // let i = 0;
    // for (let j = 0; j < nums.length; j++) {
    //     if (nums[j] != nums[i]) 
    //         nums[++i] = nums[j];
    // }
    // return ++i;

    // ------------------------- 解法2 start--------------------------
    // 最好记  👍 👍 👍 👍 
    // 最优解  😘 😘 😘 😘 😘
    for (i = 0; i < nums.length; i++) {
        if (nums[i] == nums[i+1]) {
            nums.splice(i, 1);
            i--;
        }
    }

    // ------------------------- 解法3 start--------------------------
    // 最好记  👍 👍 👍 👍 👍
    // 最优解  😘 😘 😘
    // nums.splice(0, nums.length, ...(new Set(nums)));

    
    // ------------------------- 解法4 start-------------------------- forEach 解法
    // 最好记  👍 👍 👍
    // 最优解  😘 😘 😘
    // let i = 0;
    // nums.forEach(function (elem) {
    //     if (elem !== nums[i]) {
    //         nums[++i] = elem;
    //     }
    // });
    // return nums.length && i + 1;

    // ------------------------- 解法5 start --------------------------
    // 最好记  👍 👍
    // 最优解  😘 😘 😘
    // let i = 0;
    // for (let j = 1; j < nums.length; j++) {
    //     if (nums[j] === nums[j - 1]) {
    //         i++;
    //     } else {
    //         nums[j - i] = nums[j];
    //     }
    // }
    // return nums.length - i;

};
// @lc code=end

console.log(
    removeDuplicates([1, 1, 2])
);
