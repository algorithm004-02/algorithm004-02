//You are climbing a stair case. It takes n steps to reach to the top. 
//
// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top? 
//
// Note: Given n will be a positive integer. 
//
// Example 1: 
//
// 
//Input: 2
//Output: 2
//Explanation: There are two ways to climb to the top.
//1. 1 step + 1 step
//2. 2 steps
// 
//
// Example 2: 
//
// 
//Input: 3
//Output: 3
//Explanation: There are three ways to climb to the top.
//1. 1 step + 1 step + 1 step
//2. 1 step + 2 steps
//3. 2 steps + 1 step
// 
// Related Topics Dynamic Programming


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int climbStairs(int n) {
        if (n <= 1) return n;

        int twoStepBefore = 1;
        int oneStepBefore = 2;
        int allWays = 2;
        //使用动态规划的方式，bottom up 自底向上的进行
        //将计算过的结果进行缓存
        for (int i = 2; i < n; i++) {
            allWays = twoStepBefore + oneStepBefore;
            twoStepBefore = oneStepBefore;
            oneStepBefore = allWays;
        }
        return allWays;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
