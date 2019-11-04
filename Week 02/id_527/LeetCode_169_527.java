/*
 * @lc app=leetcode id=169 lang=java
 *
 * [169] Majority Element
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        return findMajority(nums, 0, nums.length - 1);
    }

    public int findMajority(int[] nums, int low, int high) {
        if (low == high) {
            return nums[low];
        }
        int mid = (high - low) / 2 + low;
        int left = findMajority(nums, low, mid);
        int right = findMajority(nums, mid + 1, high);
        if (left == right) {
            return left;
        }
        int leftCount = count(nums, left, low, high);
        int rightCount = count(nums, right, low, high);
        return leftCount > rightCount ? left : right;
    }

    int count(int[] nums, int num, int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    // public int majorityElement(int[] nums) {
    // Arrays.sort(nums);
    // return nums[nums.length / 2];
    // }
}
// @lc code=end
