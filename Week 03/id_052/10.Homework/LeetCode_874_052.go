package leetcode

import "math"

func robotSim(commands []int, obstacles [][]int) int {
	set := make(map[int]bool)
	for _, obs := range obstacles {
		set[encode(obs[0], obs[1])] = true
	}
	dirs := [][]int{{0, 1}, {1, 0}, {0, -1}, {-1, 0}}
	d, x, y, result := 0, 0, 0, 0
	for _, c := range commands {
		if c == -1 {
			d++
			if d == 4 {
				d = 0
			}
		} else if c == -2 {
			d--
			if d == -1 {
				d = 3
			}
		} else {
			for c > 0 && !set[encode(x+dirs[d][0], y+dirs[d][1])] {
				c--
				x += dirs[d][0]
				y += dirs[d][1]
			}
		}
		result = int(math.Max(float64(result), float64(x*x+y*y)))
	}
	return result
}
func encode(x, y int) int {
	x &= 0xFFFF
	y &= 0xFFFF
	return x<<16 | y
}
