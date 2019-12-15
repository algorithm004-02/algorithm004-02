package leetcode

import "sort"

/*
 * @lc app=leetcode.cn id=1122 lang=golang
 *
 * [1122] 数组的相对排序
 */

// @lc code=start
func relativeSortArray(arr1 []int, arr2 []int) []int {
	lastIdx := 0
	for i := 0; i < len(arr2); i++ {
		for j := lastIdx; j < len(arr1); j++ {
			if arr1[j] == arr2[i] {
				arr1[lastIdx], arr1[j] = arr1[j], arr1[lastIdx]
				lastIdx++
			}
		}
	}
	sort.Ints(arr1[lastIdx:])
	return arr1
}

// @lc code=end
