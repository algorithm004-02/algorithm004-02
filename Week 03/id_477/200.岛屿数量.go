package leetcode

/*
 * @lc app=leetcode.cn id=200 lang=golang
 *
 * [200] 岛屿数量
 */

// @lc code=start
func numIslands(grid [][]byte) int {
	if len(grid) == 0 {
		return 0
	}
	isLandsCount := 0
	nr := len(grid)
	nc := len(grid[0])
	for i := 0; i < nr; i++ {
		for j := 0; j < nc; j++ {
			if grid[i][j] == '1' {
				isLandsCount++
				dfsIsLands(grid, i, j, nr, nc)
			}
		}
	}
	return isLandsCount
}

func dfsIsLands(grid [][]byte, i, j, nr, nc int) {
	// 越界、0
	if i < 0 || j < 0 || i >= nr || j >= nc || grid[i][j] == '0' {
		return
	}
	grid[i][j] = '0'
	dfsIsLands(grid, i-1, j, nr, nc)
	dfsIsLands(grid, i+1, j, nr, nc)
	dfsIsLands(grid, i, j-1, nr, nc)
	dfsIsLands(grid, i, j+1, nr, nc)
}

// @lc code=end
