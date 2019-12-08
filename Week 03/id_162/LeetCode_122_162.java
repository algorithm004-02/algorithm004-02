class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;

        // 需要相邻的两天对比，则从1~len or 0~len-1
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                res += prices[i] - prices[i - 1];
            }
        }
        return res;
    }
}