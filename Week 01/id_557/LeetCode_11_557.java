/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {

        if (height.length < 2)
            return 0;
        int low = 0;
        int high = height.length - 1;
        int maxArea = 0;
        while (low < high) {
            maxArea = Math.max((high - low) * Math.min(height[low], height[high]), maxArea);
            if (height[low] < height[high]) {
                low++;
            } else {
                high--;
            }
        }
        return maxArea;

    }
}
// @lc code=end
