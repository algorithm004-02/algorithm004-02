package algorithm.LeetCode;

import java.util.Arrays;

/**
 * describe:
 *
 * @author lixilong
 * @date 2019/01/28
 */
public class _300_LengthOfLIS {


//官方答案： https://leetcode.com/problems/longest-increasing-subsequence/solution/
  //方法1： Runtime: 1 ms, faster than 93.90%
  public int lengthOfLIS(int[] nums) {
    int[] dp = new int[nums.length];
    int len = 0;
    for (int num : nums) {
      int i = Arrays.binarySearch(dp, 0, len, num);
      if (i < 0) {
        i = -(i + 1);
      }
      dp[i] = num;
      if (i == len) {
        len++;
      }
    }
    return len;
  }


}
