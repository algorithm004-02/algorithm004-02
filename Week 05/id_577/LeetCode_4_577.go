/**
tmp := dp[i-1][k][0]
dp[i][k][0] = dp[i-1][k][0], dp[i-1][k][1] + prices[i]
dp[i][k][0] =dp[i-1][k][1],temp- prices[i]

==>

dp[i][0] = dp[i-1][0], dp[i-1][1] + prices[i]
dp[i][0] =dp[i-1][1],temp- prices[i]

**/
func maxProfit(prices []int) int {
    
    dp_i_0 := 0
    
    dp_i_1 := math.MinInt32
    
    
    for i:=0; i< len(prices); i++ {
        
        temp := dp_i_0
        
        dp_i_0 = max(dp_i_0, dp_i_1 + prices[i])
        dp_i_1 = max(dp_i_1, temp - prices[i])
    }
    
    return dp_i_0
    
    
    
    
}

func max(x, y int) int{
    
    if x > y {
        return x
    }
    
    return y
    
}