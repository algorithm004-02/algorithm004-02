package min_path_sum

func minPathSum(grid [][]int) int {
	if len(grid) == 0 || len(grid[0]) == 0 {
		return 0
	}
	row := len(grid)
	colum := len(grid[0])
	dp := make([][]int, row)
	sumC := grid[0][0]
	for i := 0; i < row; i++ {
		dp[i] = make([]int, colum)
		if i == 0 {
			sumR := 0
			for j := 0; j < colum; j++ {
				sumR += grid[0][j]
				dp[0][j] = sumR
			}
		} else {
			sumC += grid[i][0]
			dp[i][0] = sumC
		}
	}

	for i := 1; i < row; i++ {
		for j := 1; j < colum; j++ {
			dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + grid[i][j]
		}
	}

	return dp[row-1][colum-1]
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}
