func longestCommonSubsequence(text1 string, text2 string) int {
    
    m := len(text1)
    n := len(text2)
    text1_array := []rune(text1)
    text2_array  := []rune (text2)
    
    dp := [][]int{}
    
    for i:=0; i< m; i++{
        for j:=0; j< n;j++ {
            if  text1_array[i] == text2_array[j]  {
                dp[i+1][j+1] = dp[i][j] + 1
                
            } else if i >=1 && j>=1{
                dp[i+1][j+1] = max(dp[i][j+1], dp[i+1][j])
                
            }
            
        }
    }
    
    return dp[m][n]
    
}

func max(x, y int)int {
    
    if x > y {
        return x
    }
    
    return y
    
}