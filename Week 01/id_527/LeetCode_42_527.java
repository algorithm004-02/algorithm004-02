/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        int total = 0;
        int left = 1;
        int right = height.length - 2;
        int maxLeft = 0;
        int maxRight = 0;
        for (int i = 1; i < height.length - 1; i++) {
            if (height[left - 1] < height[right + 1]) {
                maxLeft = Math.max(maxLeft, height[left - 1]);
                if (maxLeft > height[left]) {
                    total += maxLeft - height[left];
                }
                left++;
            } else {
                maxRight = Math.max(maxRight, height[right + 1]);
                if (maxRight > height[right]) {
                    total += maxRight - height[right];
                }
                right--;
            }
        }
        return total;
    }
}
// @lc code=end
