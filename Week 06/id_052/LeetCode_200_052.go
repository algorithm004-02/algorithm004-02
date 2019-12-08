package leetcode

// Time: O(m*n), Space: O(m*n)
func numIslands(grid [][]byte) int {
	if grid == nil || len(grid) == 0 || grid[0] == nil || len(grid[0]) == 0 {
		return 0 // 二维数组为空，或长度为0，直接返回0个小岛
	}
	m, n := len(grid), len(grid[0]) // 二维数组长宽分别赋值给m和n
	visit := make([][]bool, m)      // 定义m*n的辅助数组，记录元素是否被访问过
	for i := 0; i < len(visit); i++ {
		visit[i] = make([]bool, n)
	}

	num := 0                 // 初始化小岛数量为0
	for i := 0; i < m; i++ { // 遍历二维数组
		for j := 0; j < n; j++ {
			if grid[i][j] == '0' || visit[i][j] {
				continue // 数组元素为0或已被访问过
			} // 就不执行以下操作，继续循环
			num++                  // 否则说明当前元素是未被访问过的小岛一部分，小岛数量+1
			dfs(grid, visit, i, j) // 把小岛上的其他元素都标记为已访问
		}
	}
	return num // 遍历结束后返回小岛数量
}

// g: 输入二维数组,visit: 是否被访问的二维数组,遍历的初始下标i, j
func dfs(g [][]byte, visit [][]bool, i, j int) {
	m, n := len(g), len(g[0]) // g的初始两个维度长度赋值给m和n
	if i < 0 || i >= m || j < 0 || j >= n || g[i][j] == '0' || visit[i][j] {
		return // i或j越界，或访问元素为0，或坐标已经访问过，直接返回
	}
	visit[i][j] = true    // 把该坐标标记为已访问
	dfs(g, visit, i-1, j) // 依次递归调用该坐标的上
	dfs(g, visit, i+1, j) // 下
	dfs(g, visit, i, j-1) // 左
	dfs(g, visit, i, j+1) // 右元素
}
