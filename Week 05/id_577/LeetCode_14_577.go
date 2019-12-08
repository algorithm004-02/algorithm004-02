/*
 dp[i][j]  stone i can or can't jump as size of j
 
 j < i
 
 dist = stones[i+1]  - stone[j]
 
 if dp[j][dist] 
 
 dp[i][dist] = true
 dp[i][dist-1] = true
 dp[i][dist+1]  = true
 
 */
func canCross(stones []int) bool {
    
    n := len(stones)
    
    if n == 0  {
        return false
    }
    
    dp := make([][]bool,n)
    
    for i:=0; i < n; i++ {
        dp[i] =make([]bool, n+1)
    }
    
    dp[0][1] = true
    for i:=1; i< n; i++ {
        
        //dp[i] = make([]int, len(stones[0]))
        for j:=0; j< i; j++ {
            
            dist := stones[i] - stones[j]
            
            if dist < 0 || dist > n || !dp[j][dist] {//Attention: dp[j] not dp[i]
                
                continue
            }
            
            dp[i][dist] = true
            
            if (dist - 1)  >=0 {
                
                dp[i][dist-1] = true
                
            }
            
            if (dist + 1 ) <= n {
                dp[i][dist + 1] = true
            }
            //the last
            if i == n -1 {
                return true
            }
            
            
            
        }
        
        
    
    }
    
    
    return false
    
    
    
    
    
}