package leetcode

func totalNQueens(n int) int {
	if n == 0 {
		return 0
	}
	cols := make([]bool, n)
	d1 := make([]bool, 2*n) // 记录 '\' 方向的对角线的占用情况
	d2 := make([]bool, 2*n) // 记录 '/' 方向的对角线的占用情况
	res := 0
	dfsQueens(0, cols, d1, d2, &res)
	return res
}

func dfsQueens(r int, cols, d1, d2 []bool, res *int) {
	n := len(cols)
	if r == n {
		*res++
		return
	}
	for c := 0; c < n; c++ {
		id1 := r - c + n
		id2 := 2*n - r - c - 1
		if !cols[c] && !d1[id1] && !d2[id2] {
			cols[c], d1[id1], d2[id2] = true, true, true
			dfsQueens(r+1, cols, d1, d2, res)
			cols[c], d1[id1], d2[id2] = false, false, false
		}
	}
}
