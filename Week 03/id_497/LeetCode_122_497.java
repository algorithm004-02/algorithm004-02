class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<2)return 0;
        int index = 0;
        int total = 0;
        boolean isSale =false;
        for (int i = 0; i <prices.length ; i++) {
            if (!isSale) {
                if (prices[index] >= prices[i]) {
                    if(i<prices.length-1&&prices[i]<prices[i+1]) {
                        index = i;
                        isSale = true;
                    }
                }else {
                    isSale =true;
                }
            } else {
                if (prices[index] < prices[i]) {
                    if (i == prices.length - 1 || i < prices.length - 1 && prices[i] > prices[i + 1]) {
                        total += prices[i] - prices[index];
                        index = i;
                        isSale = false;
                    }
                }

            }
        }
        return  total;
    }

}