/*
 * @lc app=leetcode.cn id=153 lang=cpp
 *
 * [153] 寻找旋转排序数组中的最小值
 *
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/description/
 *
 * algorithms
 * Medium (49.73%)
 * Likes:    101
 * Dislikes: 0
 * Total Accepted:    20.3K
 * Total Submissions: 40.9K
 * Testcase Example:  '[3,4,5,1,2]'
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * 
 * ( 例如，数组 [0,1,2,4,5,6,7]  可能变为 [4,5,6,7,0,1,2] )。
 * 
 * 请找出其中最小的元素。
 * 
 * 你可以假设数组中不存在重复元素。
 * 
 * 示例 1:
 * 
 * 输入: [3,4,5,1,2]
 * 输出: 1
 * 
 * 示例 2:
 * 
 * 输入: [4,5,6,7,0,1,2]
 * 输出: 0
 * 
 */

// @lc code=start
class Solution {
public:
    int findMin(vector<int>& nums) {
        int l = 0, h = nums.size() - 1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            // 右递增
            if (nums[m] < nums[h] && nums[l] > nums[m]) {
                h = m;
            // 左递增
            } else if (nums[l] <= nums[m] && nums[h] < nums[m]) {
                l = m + 1;
            // 全递增
            } else {
                return nums[l];
            }
        }

        return -1;
    }
};
// @lc code=end

