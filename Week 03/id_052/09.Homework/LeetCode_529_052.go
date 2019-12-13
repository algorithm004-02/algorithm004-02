package leetcode

func updateBoard(board [][]byte, click []int) [][]byte {
	update(board, click[0], click[1])
	return board
}

func update(board [][]byte, x, y int) {
	if x < 0 || x > len(board) || y < 0 || y >= len(board[0]) {
		return
	}
	if board[x][y] != 'E' && board[x][y] != 'M' {
		return
	}
	if board[x][y] == 'M' {
		board[x][y] = 'X'
		return
	}
	cnt := 0
	for i := x - 1; i <= x+1; i++ {
		for j := y - 1; j <= y+1; j++ {
			if i == x && j == y || i < 0 || i >= len(board) || j < 0 || j >= len(board[0]) {
				continue
			}
			if board[i][j] == 'M' || board[i][j] == 'X' {
				cnt++
			}
		}
	}
	if cnt > 0 {
		board[x][y] = '0' + byte(cnt)
	} else {
		board[x][y] = 'B'
		for i := x - 1; i <= x+1; i++ {
			for j := y - 1; j <= y+1; j++ {
				if i == x && j == y || i < 0 || i >= len(board) || j < 0 || j >= len(board[0]) {
					continue
				}
				update(board, i, j)
			}
		}
	}
}
