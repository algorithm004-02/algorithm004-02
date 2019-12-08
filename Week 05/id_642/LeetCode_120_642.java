package week5;

import java.util.List;

/**
 * @Author: xiang1.li
 * @Date: 2019/11/17 16:29
 * https://leetcode-cn.com/problems/triangle/submissions/
 */
public class L120 {
  /**
   * 三角形的最小路径和.
   * */
  public int minimumTotal(List<List<Integer>> triangle) {
    /**
     * 自底向上递推
     */
    int level = triangle.size();
    // 初始dp数组多一层
    int[] dp = new int[triangle.get(level - 1).size() + 1];
    for (int i = level - 1; i >= 0; i--) {
      List<Integer> list = triangle.get(i);
      for (int j = 0; j < list.size(); j++) {
        dp[j] = list.get(j) + Math.min(dp[j], dp[j+1]);
      }
    }
    return dp[0];
  }
}
