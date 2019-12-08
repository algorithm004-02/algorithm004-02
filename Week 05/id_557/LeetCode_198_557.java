//You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night. 
//
// Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police. 
//
// Example 1: 
//
// 
//Input: [1,2,3,1]
//Output: 4
//Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//             Total amount you can rob = 1 + 3 = 4. 
//
// Example 2: 
//
// 
//Input: [2,7,9,3,1]
//Output: 12
//Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
//             Total amount you can rob = 2 + 9 + 1 = 12.
// 
// Related Topics Dynamic Programming


import java.lang.reflect.Array;
import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //从暴力递归到最好的动态规划步骤
    //1 先写出最简单的递归方法
    //递归的规则：rob(i)=Math.max(rob(i-1),rob(i-2)+nums[i])
    //rob(i)表示第i间房子必偷时的最大值

    //但是递归方法时间复杂度是指数级的（递归树），时间超时，无法通过，所以必须改进
//    public int rob(int[] nums) {
//        if (nums == null || nums.length == 0) return 0;
//        return rob(nums, nums.length - 1);
//    }
//
//    private int rob(int[] nums, int level) {
//        if (level == 0) return nums[0];
//        if (level == 1) return Math.max(nums[0], nums[1]);
//        return Math.max(rob(nums, level - 1), rob(nums, level - 2) + nums[level]);
//    }


    //2 加入记忆化搜索，将中间结果进行缓存

//    private int[] memo;
//
//    public int rob(int[] nums) {
//        if (nums == null || nums.length == 0) return 0;
//        memo = new int[nums.length];
//        Arrays.fill(memo, -1);
//        if (nums.length == 1) return nums[0];
//        memo[0] = nums[0];
//        memo[1] = Math.max(nums[0], nums[1]);
//        return rob(nums, nums.length - 1);
//    }
//
//    private int rob(int[] nums, int level) {
//        if (memo[level] != -1) return memo[level];
//        memo[level] = Math.max(rob(nums, level - 1), rob(nums, level - 2) + nums[level]);
//        return memo[level];
//    }


    //3 还可以继续优化为动态规划，递归是自顶向下，动态规划是自底向上
    //创建一个DP table, 状态转移方程是一致的

//    public int rob(int[] nums) {
//        if (nums == null || nums.length == 0) return 0;
//        int[] dp = new int[nums.length];
//        dp[0] = nums[0];
//        if (nums.length > 1) {
//            dp[1] = Math.max(nums[1], nums[0]);
//            for (int i = 2; i < nums.length; i++) {
//                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
//            }
//        }
//        return dp[nums.length - 1];
//    }


    //4 根据第3可知其实我们只需要知道之前两个点的结果即可，不用使用一个数组存储之前所有结果
    //可以继续优化

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
//        if (nums.length == 1) return nums[0];
//        int twoBefore = nums[0];
//        int oneBefore = Math.max(nums[0], nums[1]);
//        int result = oneBefore;
//        for (int i = 2; i < nums.length; i++) {
//            result = Math.max(oneBefore, twoBefore + nums[i]);
//            twoBefore = oneBefore;
//            oneBefore = result;
//        }
//        return result;
        //更简单的写法
        int oneBefore = 0;
        int twoBefore = 0;
        for (int num :
                nums) {
            int temp = Math.max(oneBefore, twoBefore + num);
            twoBefore = oneBefore;
            oneBefore = temp;
        }
        return oneBefore;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
