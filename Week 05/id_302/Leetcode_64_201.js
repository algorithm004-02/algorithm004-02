/**
 * @param {number[][]} grid
 * @return {number}
 // DP 
 
 // We use an extra matrix dp of the same size as the original matrix.
 // dp(i, j) represents the minimum  sum of the path from the index(i, j) to 
 // the bottom rightmost element. We start by initialize the bottom rightmost 
 // element of dp as the last element of the given matrix. Then for each element 
 //  starting from the bottom right, we traverse backwards and fill in the matrix with
 // the required minimum sums. Now, we need to note that at every element, we can move 
 // either rightwards or downwards. Therefore, for filling in the minimum sum, we use the equation
 // dp(i, j) = grid(i, j) + min(dp(i+1, j), dp(i, j+1))
 // taking care of the boundary conditions.
 
 
 */
 function minPathSum(grid) {
     let dp = [];
     for(let i = 0; i<grid.length; i++) {
         dp.push([]);
         for(let j=0; j<grid[0].length; j++) {
             dp[i][j] = 0
         }
    }
    for(let i=grid.length - 1; i>=0; i--) {
        for(let j=grid[0].length - 1; j>=0; j--) {
            if(i === grid.length - 1 && j !== grid[0].length - 1)
                dp[i][j] = grid[i][j] + dp[i][j+1]
            else if (j === grid[0].length - 1 && i !== grid.length - 1)
                dp[i][j] = grid[i][j] + dp[i+1][j]
            else if(j !== grid[0].length -1 && i !== grid.length - 1)
                dp[i][j] = grid[i][j] + Math.min(dp[i+1][j], dp[i][j+1])
            else
                dp[i][j] = grid[i][j]
        }
    }
    return dp[0][0];
}


