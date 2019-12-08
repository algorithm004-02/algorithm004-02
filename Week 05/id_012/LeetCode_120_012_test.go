package main

//DP方程
// dp[i][j] = min(dp[i+1][j],dp[i+1][j+1])+dp[i][j]
func minimumTotal(triangle [][]int) int {
	//初始化状态数组

	for i := len(triangle) - 2; i >= 0; i-- {
		for j := 0; j < len(triangle[i]); j++ {
			if triangle[i+1][j] < triangle[i+1][j+1] {
				triangle[i][j] += triangle[i+1][j]
			} else {
				triangle[i][j] += triangle[i+1][j+1]
			}
		}
	}
	return triangle[0][0]
}
