package week5;

/**
 * @Author: xiang1.li
 * @Date: 2019/11/16 16:13
 * https://leetcode-cn.com/problems/house-robber/
 */
public class L198 {
  /**
   * 打家劫舍问题
   * 解法1
   *
   * dp分析
   * 1、对于一间房只能是偷或者不偷.
   * 2、定义二维数组a[i][2]
   *    a[i][0]:在不偷i的情况下，从0..i可以偷的最大金额
   *    a[i][1]:在偷i的情况下，从0..i可以偷的最大金额
   * 3、对于i的位置可以偷的最大金额，一定是这两个中其中的一个.
   *
   * dp方程
   *
   * a[i][0] = Max(a[i-1][0], a[i-1][1])
   * a[i][1] = nums[i] + a[i-1][0]
   * */
  public int rob(int[] nums) {
    int len = nums.length;
    if (len == 0) {
      return 0;
    }
    int[][] dp = new int[len][2];
    dp[0][0] = 0;
    dp[0][1] = nums[0];
    for (int i = 1; i < len; i++) {
      dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
      dp[i][1] = nums[i] + dp[i-1][0];
    }
    return Math.max(dp[len-1][0], dp[len-1][1]);
  }


  /**
   * 解法2
   * 1、使用一维数组存储中间状态a[i]，表示偷i这个位置房子，前面可以偷的最大金额
   *
   * a[i] = Max(nums[i] + a[i-2], nums[i-1])
   * */
  public int rob1(int[] nums) {
    int len = nums.length;
    if (len == 0) {
      return 0;
    }
    if (len == 1) {
      return nums[0];
    }
    int[] dp = new int[len];
    dp[0] = nums[0];
    dp[1] = Math.max(dp[0], nums[1]);
    for (int i = 2; i < len; i++) {
      dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
    }
    return dp[len-1];
  }

  public static void main(String[] args) {
    int[] arr = {3, 2, 1, 8, 2, 3, 4};
    L198 l198 = new L198();
    l198.rob1(arr);
  }
}
