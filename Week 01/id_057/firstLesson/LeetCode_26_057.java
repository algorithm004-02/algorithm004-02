package app.homework;

/*
 * @lc app=leetcode id=26 lang=java
 *
 * [26] Remove Duplicates from Sorted Array
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 *
 * algorithms
 * Easy (42.16%)
 * Likes:    1776
 * Dislikes: 3848
 * Total Accepted:    712.1K
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
 * being modified toÂ 0, 1, 2, 3, andÂ 4 respectively.
 * 
 * It doesn't matter what values are set beyondÂ the returned length.
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
class Solution {
    /**
     * 利用双指针，可以在每次循环中处理两个元素
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            } 
        }
        return i+1;
    }

    /**
     * 暴力求解，累计重复元素，出现重复元素后把重复元素后面的往前搬移一个位置
     * 时间复杂度O(n^2)、O(n^3)
     * 空间复杂度O(1)
     * @param nums
     * @return
     */
    public int removeDuplicates_by_bruce(int[] nums) {
        int duplicates = 0;
        for (int i = 0; i < nums.length - 1 - duplicates; i++) {
            for (int j = i+1; j < nums.length - duplicates; j++) {
                if (nums[i] == nums[j]) {
                    duplicates++;
                    nums[j] = nums[0] - duplicates;
                    for (int j2 = j+1; j2 < nums.length - duplicates + 1; j2++) {
                        int temp = nums[j2];
                        nums[j2] = nums[j2-1];
                        nums[j2-1] = temp; 
                    }
                    //下一个元素仍然可能重复
                    j--;
                }
            }
        }
        return nums.length - duplicates;
    }
}
// @lc code=end

