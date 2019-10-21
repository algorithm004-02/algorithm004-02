/**
给定?n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。



上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。?感谢 Marcos 贡献此图。

示例:

输入: [0,1,0,2,1,0,1,3,2,1,2,1]
输出: 6

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/trapping-rain-water
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

*/

class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
			return 0;
		}
		int result = 0;
		int[] left = new int[height.length];
		left[0] = height[0];
		int right = height[height.length-1];
		for (int i = 1; i < height.length; i++) {
			left[i] = Math.max(left[i - 1], height[i]);
		}
		for (int i = height.length - 2; i >= 0; i--) {
			right = Math.max(right, height[i]);
			result += Math.min(left[i], right) - height[i];
		}
		return result;
    }
}