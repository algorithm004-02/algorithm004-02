/**
i mean day, k mean trade count, 0 mean sell, 1 mean buy
dp[i][k][0] = dp[i-1][k][0] , dp[i-1][k][1] + prices[i]

解释：今天我没有持有股票，有两种可能：
要么是我昨天就没有持有，然后今天选择 rest，所以我今天还是没有持有；
要么是我昨天持有股票，但是今天我 sell 了，所以我今天没有持有股票了。

dp[i][k][1] = dp[i-1][k][1], dp[i-1][k][0] - prices[i]
解释：今天我持有着股票，有两种可能：
要么我昨天就持有着股票，然后今天选择 rest，所以我今天还持有着股票；
要么我昨天本没有持有，但今天我选择 buy，所以今天我就持有股票了


**/
func maxProfit(prices []int) int {
    
     n := len(prices)
            
        dp_i_0 := 0
        dp_i_1 := math.MinInt32
            
        for i:=0; i< n; i++ {
           //dp_i_0_temp := dp_i_0
           dp_i_0 = max(dp_i_0, dp_i_1 + prices[i])
           dp_i_1 = max(dp_i_1,  - prices[i])
               
        }
    
       return dp_i_0;
    
}

func max(x, y int) int {
    if x > y {
        return x
    }
    
    return y
}