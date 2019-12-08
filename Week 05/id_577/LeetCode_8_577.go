/**
  dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i] - fee)
解释：相当于买入股票的价格升高了。
在第一个式子里减也是一样的，相当于卖出股票的价格减小了。


**/
func maxProfit(prices []int, fee int) int {
    
    dp_i_0,dp_i_1 :=0, math.MinInt32
    
    for _, price := range prices {
        temp := dp_i_0
        
        dp_i_0  = max(dp_i_0, dp_i_1 + price)
        
        dp_i_1 = max(dp_i_1, temp - price - fee)
    }
    
    return dp_i_0
    
    
}

func max(x, y int) int {
    if x > y {
        return x
    }
    
    return y 
}