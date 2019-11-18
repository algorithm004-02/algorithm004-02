package leetcode.editor.cn;

//给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划
public class LeetCode_152_537 {

    public static void main(String[] args) {
        Solution solution = new LeetCode_152_537().new Solution();
    }

    private

//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProduct(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int max = nums[0];
            int containsRightMax = 1;
            int containsRightMin = 1;
            int temp;
            for (int i = 0; i < nums.length; i++) {
                temp = containsRightMax;
                containsRightMax = Math.max(Math.max(containsRightMax * nums[i], nums[i]), containsRightMin * nums[i]);
                containsRightMin = Math.min(Math.min(temp * nums[i], nums[i]), containsRightMin * nums[i]);
                max = Math.max(containsRightMax, max);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}