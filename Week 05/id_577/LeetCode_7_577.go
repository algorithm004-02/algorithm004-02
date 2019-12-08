func maxProfit(k int, prices []int) int {
    n := len(prices)
    
    if k > n/2 {
        return max_profile_infinity(prices)
    }
    
    dp:= [][][2]int{}
    
    for i:=0; i< n; i++ {
        for j:= k; j>=1; j-- {
            if (i-1) == -1 {
                dp[i][j][0] = 0
                dp[i][j][1] = -prices[i]
                continue
            }
            
            dp[i][j][0] = max(dp[i-1][j][0], dp[i-1][j][1] + prices[i])
            dp[i][j][1] = max(dp[i-1][j][1], dp[i-1][j-1][0] - prices[i])
             
        }
    }
    
    return dp[n-1][k][0]
    
    
    
    
    
    
}

func max_profile_infinity (prices []int) int {
    
    dp_1_0, dp_1_1 := 0, math.MinInt32
    
    for _, price := range prices {
        
        temp := dp_1_0
        
        dp_1_0 = max(dp_1_0, dp_1_1 + price)
        dp_1_1 = max(dp_1_1, temp - price)
        
    }
    
    return dp_1_0
    
    
    
    
    
    
    
}

func max (x, y  int)  int {
    if x > y  {
        return x
    }
    
    return y
}