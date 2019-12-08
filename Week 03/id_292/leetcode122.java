 public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                sum += prices[i] = prices[i - 1];
            }
        }
        return sum;
    }