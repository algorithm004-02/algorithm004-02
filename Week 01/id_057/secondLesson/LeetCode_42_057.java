package app.homework;

/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 *
 * https://leetcode.com/problems/trapping-rain-water/description/
 *
 * algorithms
 * Hard (45.18%)
 * Likes:    4657
 * Dislikes: 82
 * Total Accepted:    364.6K
 * Total Submissions: 805.8K
 * Testcase Example:  '[0,1,0,2,1,0,1,3,2,1,2,1]'
 *
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 * 
 * 
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 * In this case, 6 units of rain water (blue section) are being trapped. Thanks
 * Marcos for contributing this image!
 * 
 * Example:
 * 
 * 
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * 
 */

// @lc code=start
class Solution {
    /**
     * 按列求，只看懂了这个解法
     * 时间复杂度O(n^2)
     * 空间复杂度O(1)
     * @param height
     * @return
     */
    public int trap(int[] height) {
        
        //按照网友的思路，最左右两端的列不用考虑
        //要求解的列，需要找出列左右两边最高的墙的高度中的最小值
        //第一种情况，min(leftHigh,rightHigh) > currentHigh,计算雨水
        //第二种情况，min(leftHigh,rightHigh) <= currentHigh,不计算雨水
        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int left_max_height = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (left_max_height < height[j]) {
                    left_max_height = height[j];
                }
            }

            int right_max_height = 0;
            for (int j = i + 1; j < height.length; j++) {
                if (right_max_height < height[j]) {
                    right_max_height = height[j];
                }
            }

            int final_max_height = Math.min(left_max_height, right_max_height);
            if (final_max_height > height[i]) {
                sum = sum + (final_max_height - height[i]);
            }
        }

        return sum;
    }
}
// @lc code=end

