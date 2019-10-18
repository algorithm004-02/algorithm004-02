/*
 * @lc app=leetcode id=26 lang=golang
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
func removeDuplicates(nums []int) int {
	nlen := len(nums)
	if nlen == 0 {
		return 0
	}

	// ------------------------- 解法1 start --------------------------
	// 双指针位移,若不相等, out长度即为去重数组长度
	// 最好记  👍 👍 👍 👍 👍
	// 最优解  😘 😘 😘 😘 😘
	out := 1
	for i := 1; i < len(nums); i++ {
		if nums[i-1] != nums[i] {
			nums[out] = nums[i]
			out++
		}
	}
	return out

	// ------------------------- 解法2 start --------------------------
	// 最好记  👍 👍 👍
	// 最优解  😘 😘 😘 😘 😘
	// curIdx, prev := 0, nums[0]
	// for i := 1; i < nlen; i++ {
	// 	if nums[i] != prev {
	// 		curIdx++
	// 		nums[curIdx] = nums[i]
	// 		prev = nums[i]
	// 	}
	// }
	// return curIdx + 1

}

// @lc code=end

