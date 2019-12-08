/**

the last character of word1 == word2
dp[len(word1)][len(word2)][0] = dp[i-1][j-1],

the last character of word1 != word1
dp[len(workd1)][len(word2)][1] = min(dp[i-1][j-1](replace),dp[i-1][j] ,dp[i][j-1])  + 1

if i== 1, j==1

**/



func minDistance(word1 string, word2 string) int {
    
    m := len(word1)
    n := len(word2)
    
    dp := make([][]int, m)
    dp[0] = make([]int, n)
    
    
    
    for i:=0; i< m; i++ {
       for j:=0; j< n; j++ {
           
           //start point
           
           if i== 0 && j == 0{
               dp[i][j] = 0
           }
           
           //first row
           
           if i==0 && j > 0{
               dp[i][j] = dp[i][j -1] + 1
           }
           
           //first column
           
           if j== 0 && i > 0{
               dp[i][j] = dp[i-1][j] + 1
           }
           
           if word1[i] == word2[j] {
               
               dp[i][j] = dp[i-1][j-1]
               
           }  else {
               
               if i > 1 && j> 1 {
               
                   dp[i][j] = min(dp[i-1][j-1], min(dp[i-1][j], dp[i][j-1])) + 1
                   
               }
               
           }
           
            
        }
    }
    
    return dp[m-1][n-1]
    
    
    
}

func min (x, y int)int {
    if x < y  {
        return x
    }
    
    return y
}