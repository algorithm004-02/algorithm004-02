class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        int min = Integer.MAX_VALUE;
        int sub;
        for (int i = 0; i < prices.length - 1; i++) {
            min = min > prices[i] ? prices[i] : min;
            sub = prices[i + 1] - min;
            res = res < sub ? sub : res;
        }
        return res;  
    }
}