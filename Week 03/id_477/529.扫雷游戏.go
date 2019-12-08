package leetcode

/*
 * @lc app=leetcode.cn id=529 lang=golang
 *
 * [529] 扫雷游戏
 */

// @lc code=start
func updateBoard(board [][]byte, click []int) [][]byte {
	x, y := click[0], click[1]
	if board[x][y] == 'M' {
		board[x][y] = 'X'
		return board
	}
	helperUpdateBoard(board, x, y)
	return board
}

func getNums(board [][]byte, x, y int) int {
	var count int
	for i := -1; i < 2; i++ {
		for j := -1; j < 2; j++ {
			if i == 0 && j == 0 {
				continue
			}
			r, c := x+i, y+j
			if r >= 0 && c >= 0 && r < len(board) && c < len(board[0]) && board[r][c] == 'M' {
				count++
			}
		}
	}
	return count
}

func helperUpdateBoard(board [][]byte, x, y int) {
	// terminal
	// if x < 0 || y < 0 || x >= len(board) || y >= len(board[0]) || board[x][y] != 'E' {
	// return
	// }
	// process current
	// 如果没有地雷相邻则改为B，否则改为相邻的地雷数量
	num := getNums(board, x, y)
	if num > 0 {
		board[x][y] = byte('0' + num)
	} else {
		board[x][y] = 'B'
		// drill down
		for i := -1; i < 2; i++ {
			for j := -1; j < 2; j++ {
				if i == 0 && j == 0 {
					continue
				}
				r, c := x+i, y+j
				if r >= 0 && c >= 0 && r < len(board) && c < len(board[0]) && board[r][c] == 'E' {
					helperUpdateBoard(board, r, c)
				}
			}
		}
	}
}

// @lc code=end
