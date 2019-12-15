func longestValidParentheses(s string) int {
    
    n := len(s)
    
    if n ==  0 {
        return 0
    }
    
    p := []rune(s)
    
    dp :=make([]int, n)
    
    max_result :=0
    
    for i:=1; i< n; i++ {
        
        if p[i] == ')' {
            if p[i-1] == '(' {
                
                if i >= 2 {
                    
                    dp[i] = dp[i-2] + 2
                    
                } else {
                    dp[i] = 2
                }
                
            } else if (i- dp[i-1]) > 0 && p[i- dp[i-1] -1] == '(' {
                
                if i - dp[i-1] - 2 > 0 {
                    dp[i] = dp[i-1] + dp[i- dp[i-1] - 2] + 2
                } else {
                    dp[i] = dp[i-1] + 2
                }
                
            }
            
            max_result = max(max_result, dp[i])
        }
        
        
    }
    
    return max_result
    
    
    
}

func max(x, y int) int {
    if x >y  {
        return x
    }
    
    return y
}