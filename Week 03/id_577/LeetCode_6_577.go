func maxProfit(prices []int) int {
    
    maxprofit := 0
    
    for i:= 1; i < len(prices); i++ {
        if prices[i] > prices[i - 1] {
            maxprofit = maxprofit + prices[i] - prices[i-1]
            
        }
        
    }
    
    return maxprofit
    
    
    
    
}