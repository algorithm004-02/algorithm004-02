package leetcode.editor.cn;
//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 示例: 
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4],
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划
public class LeetCode_53_537{

    public static void main(String[] args) {
         Solution solution = new LeetCode_53_537().new Solution();
    }
    private 

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int containsRightMax = 0;
        for (int i = 0; i < nums.length; i++) {
            if (containsRightMax > 0) {
                containsRightMax+=nums[i];
            }else {
                containsRightMax = nums[i];
            }
            max = Math.max(max, containsRightMax);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}