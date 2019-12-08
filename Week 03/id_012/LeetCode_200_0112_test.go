package main

import "testing"

func TestNumIsland(t *testing.T) {
	input := [][]byte{[]byte("111111"), []byte("100101")}
	t.Log(numIslands(input))
}

func numIslands(grid [][]byte) int {
	count := 0
	for y, rows := range grid {
		for x, element := range rows {
			if element == 49 {
				count++
				bfs(y, x, grid)
			}
		}
	}
	return count
}

func bfs(y int, x int, grid [][]byte) {

	if y+1 != len(grid) {
		if grid[y+1][x] == 49 {
			grid[y+1][x] = 48
			bfs(y+1, x, grid)
		}
	}

	if y-1 >= 0 {
		if grid[y-1][x] == 49 {
			grid[y-1][x] = 48
			bfs(y-1, x, grid)
		}
	}

	if x+1 != len(grid[y]) {
		if grid[y][x+1] == 49 {
			grid[y][x+1] = 48
			bfs(y, x+1, grid)
		}
	}

	if x-1 >= 0 {
		if grid[y][x-1] == 49 {
			grid[y][x-1] = 48
			bfs(y, x-1, grid)
		}
	}

	return
}
