package id_432
//从左上角开始
func minPathSum1(grid [][]int) int {
	lengrid := len(grid) - 1
	lengrid0 := len(grid[0]) - 1
	for i := 0; i <= lengrid; i++ {
		for j := 0; j <= lengrid0; j++ {
			if i == 0 && j != 0 {
				grid[i][j] = grid[i][j] + grid[i][j - 1]
			} else if j == 0 && i != 0 {
				grid[i][j] = grid[i][j] + grid[i - 1][j]
			} else if i != 0 && j != 0  {
				if grid[i - 1][j] >= grid[i][j - 1] {
					grid[i][j] = grid[i][j] +  grid[i][j - 1]
				} else {
					grid[i][j] = grid[i][j] +  grid[i - 1][j]
				}
			}
		}
	}
	return grid[lengrid][lengrid0]
}

//从右上角开始
func minPathSum(grid [][]int) int {
	lengrid := len(grid) - 1
	lengrid0 := len(grid[0]) - 1
	for i := lengrid; i >= 0; i-- {
		for j := lengrid0; j >= 0; j-- {
			if i == lengrid && j != lengrid0 {
				grid[i][j] = grid[i][j] + grid[i][j + 1]
			} else if j == lengrid0 && i != lengrid {
				grid[i][j] = grid[i][j] + grid[i + 1][j]
			} else if i != lengrid && j != lengrid0  {
				if grid[i + 1][j] >= grid[i][j + 1] {
					grid[i][j] = grid[i][j] +  grid[i][j + 1]
				} else {
					grid[i][j] = grid[i][j] +  grid[i + 1][j]
				}
			}
		}
	}
	return grid[0][0]
}