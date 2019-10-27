package leetcode.editor.cn;

//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
// 
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。 
//
// 示例: 
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6 
// Related Topics 栈 数组 双指针
public class TrappingRainWater42 {

    public static void main(String[] args) {
        Solution solution = new TrappingRainWater42().new Solution();
    }

    private

//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            if (height.length < 2) {
                return 0;
            }
            int totalWater = 0;
            int[] maxFromLeft = new int[height.length];
            int[] maxFromRight = new int[height.length];
            maxFromLeft[0] = 0;
            maxFromRight[height.length - 1] = 0;
            for (int i = 1; i < height.length; ++i) {
                maxFromLeft[i] = Math.max(maxFromLeft[i - 1], height[i - 1]);
            }
            for (int i = height.length - 2; i >= 0; i--) {
                maxFromRight[i] = Math.max(maxFromRight[i + 1], height[i + 1]);
            }
            for (int i = 0; i < height.length; i++) {
                int water = Math.min(maxFromLeft[i], maxFromRight[i]) - height[i];
                totalWater += Math.max(water, 0);
            }

            return totalWater;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}