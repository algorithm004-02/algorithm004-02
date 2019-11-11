package leetcode

/*
 * @lc app=leetcode.cn id=200 lang=golang
 *
 * [200] 岛屿数量
 */

// @lc code=start
var dx = [4]int{-1, 0, 1, 0}
var dy = [4]int{0, -1, 0, 1}

func numIslands(grid [][]byte) int {
	cnt := 0
	for i := 0; i < len(grid); i++ {
		for j := 0; j < len(grid[i]); j++ {
			if grid[i][j] == '1' {
				dfs(grid, i, j)
				cnt++
			}
		}
	}
	return cnt
}

func dfs(grid [][]byte, x, y int) {
	if judge(grid, x, y) {
		return
	}
	grid[x][y] = '0'
	for i := 0; i < 4; i++ {
		dfs(grid, x+dx[i], y+dy[i])
	}
}

func judge(grid [][]byte, x, y int) bool {
	if x < 0 || x >= len(grid) || y < 0 || y >= len(grid[0]) {
		return true
	}
	if grid[x][y] == '0' {
		return true
	}
	return false
}

// @lc code=end
