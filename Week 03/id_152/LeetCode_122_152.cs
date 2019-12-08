public class Solution {
    public int MaxProfit(int[] prices) {
        int maxProfit = 0;
        if (prices == null || prices.Length < 2) return maxProfit;
        
        for (int i = 1; i < prices.Length; i++)
        {
            maxProfit += prices[i] > prices[i - 1] ? prices[i] - prices[i - 1]: 0;
        }
               
        return maxProfit;
    }
}