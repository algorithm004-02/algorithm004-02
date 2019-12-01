package leetcode

func isValidSudoku(board [][]byte) bool {
	set := make(map[byte]bool) // 定义辅助集合set
	for i := 0; i < 9; i++ {
		set = make(map[byte]bool) // 清空集合
		for j := 0; j < 9; j++ {  // 处理第i行
			if board[i][j] == '.' {
				continue // 当前位置没有填充数字
			}
			if _, ok := set[board[i][j]]; ok {
				return false // 集合中已经包含了该数字
			} else {
				set[board[i][j]] = true
			}
		}
		set = make(map[byte]bool) // 清空集合
		for j := 0; j < 9; j++ {  // 处理第i列
			if board[j][i] == '.' {
				continue
			}
			if _, ok := set[board[j][i]]; ok {
				return false // 集合中已经包含了该数字
			} else {
				set[board[j][i]] = true
			}
		}
		set = make(map[byte]bool) // 清空集合
		for j := 0; j < 9; j++ {  // 处理第小正方形
			r, c := 3*(i/3)+j/3, 3*(i%3)+j%3
			if board[r][c] == '.' {
				continue
			}
			if _, ok := set[board[r][c]]; ok {
				return false // 集合中已经包含了该数字
			} else {
				set[board[r][c]] = true
			}
		}
	}
	return true
}
LeetCode_36_052.go
