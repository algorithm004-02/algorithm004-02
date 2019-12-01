package leetcode

/*
 * @lc app=leetcode.cn id=547 lang=golang
 *
 * [547] 朋友圈
 */

// @lc code=start
func findCircleNum(M [][]int) int {
	visited := make([]int, len(M))
	count := 0
	q := make([]int, 0)
	for i := 0; i < len(M); i++ {
		if visited[i] == 0 {
			q = append(q, i)
			for len(q) != 0 {
				s := q[0]
				q = q[1:]
				visited[s] = 1
				for j := 0; j < len(M); j++ {
					if M[s][j] == 1 && visited[j] == 0 {
						q = append(q, j)
					}
				}
			}
			count++
		}
	}
	return count
}

// @lc code=end
