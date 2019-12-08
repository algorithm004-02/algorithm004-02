/**

dp[i][j] = min(dp[i-1][j], dp[i][j-1] 

i=0, j=0; or i=0, j != 0, i!=0, y=0

**/

func minPathSum(grid [][]int) int {
    
    m := len(grid)
    n := len(grid[0])
    
    for i:= 0; i< m; i++ {
        for j:=0; j< n; j++  {
            
            if i==0 &&  j== 0 {
                continue
            }
            
            if i==0 {
                grid[i][j] = grid[i][j] + grid[i][j-1]
            } else if j== 0 {
                grid[i][j] = grid[i][j] + grid[i-1][j]
                
            } else  {
                grid[i][j] = min(grid[i][j-1], grid[i-1][j]) + grid[i][j]
            }
            
            
        }
    }
    
    return grid[m-1][n-1]
    
    
}

func min(x, y  int) int {
    if x < y {
        return x
    }
    
    return y
}