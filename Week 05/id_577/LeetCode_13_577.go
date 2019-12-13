/**

dp[i][j] = min(dp[i][j-1], dp[i-1][j], dp[i-1][j-1]

*/

func maximalSquare(matrix [][]byte) int {
    
    //Check the boundary . 
    
    if matrix == nil {
        return 0
    }
    
    rows := len(matrix)
    
    if rows == 0 {
        return 0
    }
    
    cols := len(matrix[0])
    
    
    
    
    dp := make([]int, cols + 1)
    
    pre :=0
    
    max_sq := 0
    
    for i:=1; i<= rows; i++  {
        
        for j:=1;j<=cols; j++ {//must <= rows and <=cols
            
            
            temp := dp[j]
            
            if matrix[i-1][j-1] == '1' {
                dp[j] = min(dp[j-1], min(dp[j], pre))  + 1
                
                max_sq  = max(max_sq, dp[j])
            } else {
                dp[j] = 0
            }
            
            pre = temp
        }
        
    }
    
    return max_sq * max_sq
}

func max(x, y int ) int {
    if x > y {
        return x
    }
    
    return y
}


func min(x, y int ) int {
    if x < y {
        return x
    }
    
    return y
}