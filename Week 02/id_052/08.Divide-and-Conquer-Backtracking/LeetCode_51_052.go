package leetcode

func solveNQueens(n int) [][]string {
	if n == 0 {
		return [][]string{}
	}
	cols := make([]bool, n)
	d1 := make([]bool, 2*n) // 记录'\'方向的对角线的占用情况
	d2 := make([]bool, 2*n) // 记录'/'方向的对角线的占用情况
	board := make([]string, n)
	var res [][]string
	dfs(0, cols, d1, d2, board, &res)
	return res
}

func dfs(r int, cols, d1, d2 []bool, board []string, res *[][]string) {
	// 递归终止条件，访问的row行已经大于等于n*n的方格中n的个数了。
	if r == len(board) {
		// Go的切片是地址，往结果数组中添加的时候一定要复制一份新的
		// 否则会被后序操作修改
		tmp := make([]string, len(board))
		copy(tmp, board)
		*res = append(*res, tmp)
		return
	}
	// 对于每一层就是遍历所有的列
	n := len(board)
	for c := 0; c < len(board); c++ {
		id1 := r - c + n       // 标记捺的占用情况
		id2 := 2*n - r - c - 1 // 标记撇的占用情况
		// 查看该列是否被占用，记录在cols、d1和d2中
		if !cols[c] && !d1[id1] && !d2[id2] {
			b := make([]byte, n)
			for i := range b {
				b[i] = '.'
			}
			b[c] = 'Q'
			board[r] = string(b)
			// 标记占用，更新cols、d1、d2，表示该位置被占用，不能放置皇后
			cols[c], d1[id1], d2[id2] = true, true, true
			// 递归到下一层
			dfs(r+1, cols, d1, d2, board, res)
			// 解除标记不影响下次递归使用
			cols[c], d1[id1], d2[id2] = false, false, false
		}

	}
}
