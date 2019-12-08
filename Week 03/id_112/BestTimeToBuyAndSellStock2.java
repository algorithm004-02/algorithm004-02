package datastruct.greedy;

/**
 * 122. 买卖股票的最佳时机 II
 *
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

 示例 1:
 输入: [7,1,5,3,6,4]
 输出: 7
 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 *
 */
public class BestTimeToBuyAndSellStock2 {

    /**
     *
     * 方法一：峰谷法
     算法
     假设给定的数组为：
     [7, 1, 5, 3, 6, 4]
     如果我们在图表上绘制给定数组中的数字，我们将会得到：

     时间复杂度：O(n)。遍历一次。
     空间复杂度：O(1)。需要常量的空间。
     *
     */
    public int maxProfit (int[] prices) {
        if (prices==null||prices.length == 0) return 0;
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
        return  maxprofit;
    }

    /**
     * 方法二：简单的一次遍历
     * 该解决方案遵循 方法一的本身使用的逻辑，但有一些轻微的变化。
     * 在这种情况下，我们可以简单地继续在斜坡上爬升并持续增加
     * 从连续交易中获得的利润，而不是在谷之后寻找每个峰值。
     * 最后，我们将有效地使用峰值和谷值，但我们不需要跟踪峰值和谷值对应
     * 的成本以及最大利润，但我们可以直接继续增加加数组的连续数字之间的差值，
     * 如果第二个数字大于第一个数字，我们获得的总和将是最大利润。
     * 这种方法将简化解决方案。
     这个例子可以更清楚地展现上述情况：
     [1, 7, 2, 3, 6, 7, 6, 7]
     时间复杂度：O(n)，遍历一次。
     空间复杂度：O(1)，需要常量的空间。
     *
     */
    public int maxProfit2 (int[] prices) {
        if (prices==null||prices.length == 0) return 0;
        int maxprofit = 0;
        for (int i = 1;i < prices.length;i++) {
            if (prices[i] > prices[i-1])
                maxprofit += prices[i] - prices[i-1];
        }
        return maxprofit;
    }
}
