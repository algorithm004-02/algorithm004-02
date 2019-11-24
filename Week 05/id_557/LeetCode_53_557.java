//Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum. 
//
// Example: 
//
// 
//Input: [-2,1,-3,4,-1,2,1,-5,4],
//Output: 6
//Explanation: [4,-1,2,1] has the largest sum = 6.
// 
//
// Follow up: 
//
// If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle. 
// Related Topics Array Divide and Conquer Dynamic Programming


import java.lang.reflect.Array;
import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        //动态方程
        //1.子问题
        //只含当前节点本身或者当前节点以及之前的节点
        //2. 状态空间定义
        //3. DP方程
        int maxSum = nums[0];
        int sum = 0;
        for (int num :
                nums) {
            //sum = Math.max(sum + num, num);
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
