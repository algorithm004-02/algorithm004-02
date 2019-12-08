//Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product. 
//
// Example 1: 
//
// 
//Input: [2,3,-2,4]
//Output: 6
//Explanation: [2,3] has the largest product 6.
// 
//
// Example 2: 
//
// 
//Input: [-2,0,-1]
//Output: 0
//Explanation: The result cannot be 2, because [-2,-1] is not a subarray. 
// Related Topics Array Dynamic Programming


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(int[] nums) {
        //动态规划
        //1、 子问题 最大正整数，最小负数
        //2、状态空间定义
        //3、DP 方程

        int maxPositive = 1;
        int minNegative = 1;
        int ans = Integer.MIN_VALUE;
        for (int num : nums) {
            //如果是负数，就交换最大值和最小值
            //因为最小的负数和负数相乘可能得到最大的正数
            if (num < 0) {
                int temp = maxPositive;
                maxPositive = minNegative;
                minNegative = temp;
            }
            //维护最大的正数和可能的最小的负数
            maxPositive = Math.max(num, maxPositive * num);
            minNegative = Math.min(num, minNegative * num);
            //保存最大值，要么是当前最大值要么是以前的最大值
            ans = Math.max(maxPositive, ans);
        }
        return ans;
    }

    //相同思路，但是逻辑更清晰的代码
    public int maxProduct_Solution2(int[] nums) {
        if (nums.length == 0) return 0;

        int res = nums[0];
        int positive = 1;
        int negative = 1;

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (x >= 0) {
                positive = Math.max(positive * x, x);
                negative = negative * x;
            } else {
                int tmp = negative;
                negative = Math.min(positive * x, x);
                positive = tmp * x;
            }
            res = Math.max(res, positive);
            res = Math.max(res, negative);
        }
        return res;
    }

}//leetcode submit region end(Prohibit modification and deletion)
