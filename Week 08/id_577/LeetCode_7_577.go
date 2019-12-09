func isMatch(s string, p string) bool {
    
   
    
    //check boundary
    m := len(s)
    n := len(p)
    
    
    //initialize and process
    dp := make([][]bool, m+1)
    
    for i:=0; i< m+1 ;i++ {
        dp[i]= make([]bool, n+1)
        
    }
    
    //fill the dp[i][j]; don't forget and it's important
    dp[0][0] = true
    srune :=[]rune(s)
    prune :=[]rune(p)
    
    for j:=0; j< n; j++ {
        if prune[j] == '*' && dp[0][j-1] {
            dp[0][j+1]= true
        }
    }
    
    
    
    for i:=0; i< m ; i++ {
        for j:=0;j<n; j++ {
            
            if prune[j] == srune[i] {
                dp[i+1][j+1] = dp[i][j]
            } 
                
             if prune[j] == '.'{
                    dp[i+1][j+1] = dp[i][j]
                    
             } 
            
            if prune[j] == '*' {
                    
                    if prune[j-1] != srune[i] && prune[j-1] != '.' {
                        dp[i+1][j+1] = dp[i+1][j-1]
                    } else {
                        dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1])
                        
                    }
                    
                    
            }
                
        }
        
    }
    
    return dp[m][n]
    
}