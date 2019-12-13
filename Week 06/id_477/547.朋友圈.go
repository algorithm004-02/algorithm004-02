/*
 * @lc app=leetcode.cn id=547 lang=golang
 *
 * [547] 朋友圈
 */

// @lc code=start
func findCircleNum(M [][]int) int {
	if len(M) == 0 {
		return 0
	}
	var visited = make(map[int]bool)
	var count int
	for i := 0; i < len(M); i++ {
		if !visited[i] {
			findCircleNumHelper(M, visited, i)
			count++
		}
	}
	return count
}

func findCircleNumHelper(M [][]int, visited map[int]bool, i int) {
	for j := 0; j < len(M); j++ {
		if M[i][j] == 1 && !visited[j] {
			visited[j] = true
			findCircleNumHelper(M, visited, j)
		}
	}
}

// @lc code=end
