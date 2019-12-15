package leetcode

/*
 * @lc app=leetcode.cn id=36 lang=golang
 *
 * [36] 有效的数独
 */

// @lc code=start
func isValidSudoku(board [][]byte) bool {
	if len(board) == 0 || len(board[0]) == 0 {
		return false
	}
	m, n := len(board), len(board[0])
	rowSet, colSet, boxSet := make(map[int]map[byte]bool), make(map[int]map[byte]bool), make(map[int]map[byte]bool)
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if board[i][j] != '.' {
				if _, ok := rowSet[i]; !ok {
					rowSet[i] = make(map[byte]bool)
				}
				if rowSet[i][board[i][j]] {
					return false
				} else {
					rowSet[i][board[i][j]] = true
				}
				if _, ok := colSet[j]; !ok {
					colSet[j] = make(map[byte]bool)
				}
				if colSet[j][board[i][j]] {
					return false
				} else {
					colSet[j][board[i][j]] = true
				}
				boxIdx := (i/3)*3 + j/3
				if _, ok := boxSet[boxIdx]; !ok {
					boxSet[boxIdx] = make(map[byte]bool)
				}
				if boxSet[boxIdx][board[i][j]] {
					return false
				} else {
					boxSet[boxIdx][board[i][j]] = true
				}
			}
		}
	}
	return true
}

// @lc code=end
