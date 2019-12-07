package com.algorithm.qinchao.homework.week05;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/11/16 14:16
 * @description 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * 示例 1:
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2:
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_198_202 {
    /**
     * 子问题：f[i][0] = max(f[i-1][1] ,f[i-1][0] )         f[i][1] = f[i-1][0]+f[i]  0:不偷,1:偷
     * 状态数组：result[][]
     * dp方程：f[i][0] = max(f[i-1][1] ,f[i-1][0] )    f[i][1] = f[i-1][0]+f[i]  0:不偷,1:偷
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int length = nums.length;
        int[][] result = new int[length][2];
        result[0][0] = 0;
        result[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result[i][0] = Math.max(result[i - 1][1], result[i - 1][0]);
            result[i][1] = result[i - 1][0] + nums[i];
        }
        return Math.max(result[length - 1][0], result[length - 1][1]);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,9,3,1};
        System.out.println(LeetCode_198_202.rob(nums));
    }
}
