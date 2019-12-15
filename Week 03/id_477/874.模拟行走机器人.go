package leetcode

import "fmt"

/*
 * @lc app=leetcode.cn id=874 lang=golang
 *
 * [874] 模拟行走机器人
 */

// @lc code=start
func robotSim(commands []int, obstacles [][]int) int {
	dx := []int{0, 1, 0, -1}
	dy := []int{1, 0, -1, 0}
	set := make(map[string]bool)
	for _, list := range obstacles {
		key := fmt.Sprintf("%d_%d", list[0], list[1])
		set[key] = true
	}
	var di, x, y, ans int
	for _, cmd := range commands {
		switch cmd {
		case -2:
			di = (di + 3) % 4
		case -1:
			di = (di + 1) % 4
		default:
			for i := 0; i < cmd; i++ {
				nx, ny := x+dx[di], y+dy[di]
				key := fmt.Sprintf("%d_%d", nx, ny)
				if set[key] {
					break
				}
				x, y = nx, ny
				if tmp := x*x + y*y; ans < tmp {
					ans = tmp
				}
			}

		}
	}
	return ans
}

// @lc code=end
