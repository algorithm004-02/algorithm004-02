import (
"math"
)

func maxProfit(prices []int) int {
    
    dp_i_1_0 , dp_i_1_1 := 0, math.MinInt32
    dp_i_2_0, dp_i_2_1 := 0, math.MinInt32
    
    for _, price := range prices {
        dp_i_2_0 = max(dp_i_2_0, dp_i_2_1 + price)
        dp_i_2_1 = max(dp_i_2_1, dp_i_1_0 - price)
        dp_i_1_0 = max(dp_i_1_0, dp_i_1_1 + price)
        dp_i_1_1 = max(dp_i_1_1, -price)
                       
                      
    }
                       
      return dp_i_2_0
    
    
    
}

func max (x, y int) int {
    if x >y {
        return x
    }
    
    return y
}