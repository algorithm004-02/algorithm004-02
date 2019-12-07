package Week03.Chapter10;

public class LeetCode_3_122 {
    // [7,1,5,3,6,4] -- 7
    // 尽可能地完成更多的交易
    // 次购买前出售掉之前的股票
    // [7,1,3,5,6,4] -- 5
    private int maxProfit(int[] prices) {
        int net = 0;
        for (int i = 1; i < prices.length; i++) {
            int tmp = prices[i] - prices[i - 1];
            net += tmp > 0 ? tmp : 0;
        }
        return net;
    }

    public static void main(String[] args) {
        final int[] prices = {7,1,3,5,6,4};
        final LeetCode_3_122 test = new LeetCode_3_122();
        System.out.println(test.maxProfit(prices));
    }

}
