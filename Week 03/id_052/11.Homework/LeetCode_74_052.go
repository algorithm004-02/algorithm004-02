package leetcode

// Time: O(log(m*n)), Space: O(1)
func searchMatrix(matrix [][]int, target int) bool {
	if matrix == nil || len(matrix) == 0 || matrix[0] == nil || len(matrix[0]) == 0 {
		return false // []int{-1,-1}
	}

	m, n := len(matrix), len(matrix[0]) // 行数m和列数n
	low, high := 0, m*n-1               // 二维数组看成一位数组
	for low <= high {
		mid := low + (high-low)/2 // low和high中间下标
		r, c := mid/n, mid%n      // mid变为行列坐标r和c
		if target < matrix[r][c] {
			high = mid - 1
		} else if target > matrix[r][c] {
			low = mid + 1
		} else {
			return true // []int{r,c}
		}
	}
	return false // []int{-1,-1}
}
