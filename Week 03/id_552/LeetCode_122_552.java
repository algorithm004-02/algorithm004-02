package Week03;

public class Solution122 {

    //思路：只要第二天比第一天高就卖出

    public static int maxProfit(int[] prices) {

        int profile = 0, temp = 0;
        for (int i = 1; i < prices.length; i++) {

            temp = prices[i] - prices[i-1];
            if(temp > 0) profile += temp;
        }

        return profile;
    }

    public static void main(String[] args) {

        int[] prices = {7,1,5,3,6,4};
        int ret = maxProfit(prices);
        System.out.print(ret);
    }
}
