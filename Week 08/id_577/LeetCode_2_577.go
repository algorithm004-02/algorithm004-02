/**
if s[i]* 10 + s[i+1] <=26, dp[i] =dp[i + 1] + dp[i+2]
else
dp[i] = dp[i+1] 
**/
func numDecodings(s string) int {
    
    n:= len(s)
    
    if n == 0 {
        return 0
    }
    
    
    
    dp := make([]int, n+1)
    
    dp[n] = 1
    
    if s[n-1] != '0'  {
        dp[n-1] =1
    } 
    
    for i:= n-2; i>=0; i-- {
        if s[i] == '0' {
            continue
        }
        
        if (s[i] - '0') * 10 + (s[i+1] -'0') > 26 {
            dp[i] = dp[i+1]
            
        } else {
            
            dp[i] = dp[i+1] + dp[i+2]
            
        }
    }
    
    
    return dp[0]
    
    
    
    
    
}