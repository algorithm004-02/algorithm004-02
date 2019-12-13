/*
 * @lc app=leetcode.cn id=33 lang=cpp
 *
 * [33] 搜索旋转排序数组
 *
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/description/
 *
 * algorithms
 * Medium (36.09%)
 * Likes:    392
 * Dislikes: 0
 * Total Accepted:    50.3K
 * Total Submissions: 139.3K
 * Testcase Example:  '[4,5,6,7,0,1,2]\n0'
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * 
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 
 * 你可以假设数组中不存在重复的元素。
 * 
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 
 * 示例 1:
 * 
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 
 * 
 * 示例 2:
 * 
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 * 
 */

// @lc code=start
class Solution {
public:
    int search(vector<int>& nums, int target) {
        int l = 0, h = nums.size() - 1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            // 去左面找
            if ((nums[l] < nums[m] && target < nums[m] && target > nums[l]) ||
                (nums[m] < nums[h] && (target > nums[h] || target < nums[m]))) {
                h = m - 1;
            // 去右面找
            } else if ((nums[m] < nums[h] && target > nums[m] && target < nums[h]) ||
                       (nums[l] < nums[m] && (target < nums[l] || target > nums[m]))) {
                l = m + 1;
            } else {
                if (nums[l] == target) return l;
                if (nums[m] == target) return m;
                if (nums[h] == target) return h;
                return -1;
            }
        }

        return -1;
    }
};
// @lc code=end

