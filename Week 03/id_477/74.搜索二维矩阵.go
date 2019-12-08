/*
 * @lc app=leetcode.cn id=74 lang=golang
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
func searchMatrix(matrix [][]int, target int) bool {
	// 1. 循环
	// for _, list := range matrix {
	// 	if len(list) == 0 {
	// 		continue
	// 	}
	// 	if target <= list[len(list)-1] {
	// 		left, right := 0, len(list)-1
	// 		for left <= right {
	// 			mid := left + (right-left)/2
	// 			if list[mid] == target {
	// 				return true
	// 			} else if list[mid] < target {
	// 				left = mid + 1
	// 			} else {
	// 				right = mid - 1
	// 			}
	// 		}
	// 	}
	// }
	// return false
	// 2. 矩阵方式
	m := len(matrix)
	if m == 0 {
		return false
	}
	n := len(matrix[0])
	if n == 0 {
		return false
	}
	left, right := 0, m*n-1
	for left <= right {
		mid := left + (right-left)/2
		if matrix[mid/n][mid%n] == target {
			return true
		} else if matrix[mid/n][mid%n] < target {
			left = mid + 1
		} else {
			right = mid - 1
		}
	}
	return false
}

// @lc code=end
