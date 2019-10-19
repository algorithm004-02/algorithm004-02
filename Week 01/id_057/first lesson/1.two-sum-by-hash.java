package app;

import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 *
 * https://leetcode.com/problems/two-sum/description/
 *
 * algorithms
 * Easy (44.63%)
 * Likes:    12156
 * Dislikes: 423
 * Total Accepted:    2.2M
 * Total Submissions: 5M
 * Testcase Example:  '[2,7,11,15]\n9'
 *
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * Example:
 * 
 * 
 * Given nums = [2, 7, 11, 15], target = 9,
 * 
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * 
 * 
 */

// @lc code=start
class Solution {

    /**
     * 利用hash表保存访问过的元素，如果存在（target - 当前元素）则返回，否则添加当前元素至hash表中
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; numsMap.put(nums[i], i++)) {
            if (numsMap.containsKey(target - nums[i])) {
                return new int [] {numsMap.get(target - nums[i]),i};
            }
        }
        return new int [] {-1,-1};
    }
}
// @lc code=end

