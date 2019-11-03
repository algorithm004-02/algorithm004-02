package algorithm.LeetCode;

/**
 * describe:
 *
 * @author lixilong
 * @date 2019/01/25
 */
public class _122_MaxProfit {

  //官方解法： https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/solution/


//自己写的逻辑过于复杂细致，贪心法需要先看一步，再看关联。不要 过早陷入细枝末节
  public int maxProfit(int[] prices) {
    int income = 0 ,sum = 0;
    int curentPrice = prices[0];
    for (int i = 1; i < prices.length; i++) {
        if (prices[i] > curentPrice) income = prices[i] - curentPrice ; //卖出
        if (prices[i] < curentPrice) sum += curentPrice; //卖入
    }
  }

//方法1：Time Limit Exceeded  Approach 1: Brute Force
  public int maxProfit(int[] prices) {
    return calculate(prices, 0);
  }

  public int calculate(int prices[], int s) {
    if (s >= prices.length)
      return 0;
    int max = 0;
    for (int start = s; start < prices.length; start++) {
      int maxprofit = 0;
      for (int i = start + 1; i < prices.length; i++) {
        if (prices[start] < prices[i]) {
          int profit = calculate(prices, i + 1) + prices[i] - prices[start];
          if (profit > maxprofit)
            maxprofit = profit;
        }
      }
      if (maxprofit > max)
        max = maxprofit;
    }
    return max;
  }

//方法2：Approach 2: Peak Valley Approach
  public int maxProfit(int[] prices) {
    if (prices.length <= 0) return 0;
    int i = 0;
    int valley = prices[0];
    int peak = prices[0];
    int maxprofit = 0;
    while (i < prices.length - 1) {
      while (i < prices.length - 1 && prices[i] >= prices[i + 1])
        i++;
      valley = prices[i];
      while (i < prices.length - 1 && prices[i] <= prices[i + 1])
        i++;
      peak = prices[i];
      maxprofit += peak - valley;
    }
    return maxprofit;
  }

//方法3：Approach 3: Simple One Pass
    public int maxProfit(int[] prices) {
      int maxprofit = 0;
      for (int i = 1; i < prices.length; i++) {
        if (prices[i] > prices[i - 1])    //抛开干扰因素,只关心最大获利，每天可以无数次买进卖出。
          maxprofit += prices[i] - prices[i - 1]; // 所以能拿到最新差价
      }
      return maxprofit;
    }


}
