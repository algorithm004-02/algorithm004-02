package week3.work;

/**
 * @Author: xiang1.li
 * @Date: 2019/10/31 23:19
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class L122 {
  public int maxProfit(int[] prices) {
    int sum = 0;
    for (int i = 1; i < prices.length; i++) {
      if (prices[i] > prices[i - 1]) {
        sum = sum + prices[i] - prices[i - 1];
      }
    }
    return sum;
  }
}
