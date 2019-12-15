package leetcode

/*
 * @lc app=leetcode.cn id=130 lang=golang
 *
 * [130] 被围绕的区域
 */

// @lc code=start
func solve(board [][]byte) {
	if len(board) == 0 || len(board[0]) == 0 {
		return
	}
	m, n := len(board), len(board[0])
	uf := unionFind(m*n + 1)
	dummyNode := m * n
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if board[i][j] == 'O' {
				if i == 0 || j == 0 || i == m-1 || j == n-1 {
					union(uf, i*n+j, dummyNode)
				} else {
					if i > 0 && board[i-1][j] == 'O' {
						union(uf, i*n+j, (i-1)*n+j)
					}
					if i < m-1 && board[i+1][j] == 'O' {
						union(uf, i*n+j, (i+1)*n+j)
					}
					if j > 0 && board[i][j-1] == 'O' {
						union(uf, i*n+j, i*n+j-1)
					}
					if j < n-1 && board[i][j+1] == 'O' {
						union(uf, i*n+j, i*n+j+1)
					}
				}
			}
		}
	}
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if !isContact(uf, i*n+j, dummyNode) {
				board[i][j] = 'X'
			}
		}
	}
}

func unionFind(total int) []int {
	parents := make([]int, total)
	for i := range parents {
		parents[i] = i
	}
	return parents
}

func find(parent []int, i int) int {
	j := i
	for parent[i] != i {
		i = parent[i]
	}
	for parent[j] != j {
		j, parent[j] = parent[j], i
	}
	return i
}

func union(parent []int, i, j int) []int {
	p1 := find(parent, i)
	p2 := find(parent, j)
	if p1 != p2 {
		parent[p1] = p2
	}
	return parent
}

func isContact(parent []int, i, j int) bool {
	return find(parent, i) == find(parent, j)
}

// @lc code=end
