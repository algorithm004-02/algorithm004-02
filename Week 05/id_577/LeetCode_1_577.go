/*dp[day][0] = dp[day-1][0] , dp[day-1][1]
dp[day][1] = max(dp[day-1][1] , dp[day-2][0] + num)

==> dp[day] = max(dp[day-1], dp[day-2] + num)
*/


func rob(nums []int) int {
    
    dp_pre_0, dp_1 := 0, 0
    
    for _, num := range nums {
        temp := dp_1
        
        dp_1 = max(dp_1, dp_pre_0 + num)
        
        dp_pre_0 = temp
        
        
    }
    
    return dp_1
    
    
    
}

func max(x, y int)int{
    
    if x > y  {
        return x
    }
    
    return y
}