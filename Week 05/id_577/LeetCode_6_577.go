/**
dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
dp[i][1] = max(dp[i-1][1], dp[i-2][0] - prices[i])
解释：第 i 天选择 buy 的时候，要从 i-2 的状态转移，而不是 i-1 。

**/



func maxProfit(prices []int) int {
    
    dp_i_0 := 0
    dp_i_1 := math.MinInt32
    dp_pre_0 :=0 // two days ago
    
    for _, price := range prices {
        
        temp := dp_i_0 
        
        dp_i_0 = max(dp_i_0, dp_i_1 + price)
        
        dp_i_1 = max(dp_i_1, dp_pre_0 - price)
        
        dp_pre_0 = temp
    }
    
    return dp_i_0
    
    
    
}

func max(x, y int) int {
    
    if x > y  {
        return x
    }
    
    return y
}