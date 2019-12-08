package leetcode

import "sort"

/*
 * @lc app=leetcode.cn id=455 lang=golang
 *
 * [455] 分发饼干
 */

// @lc code=start
func findContentChildren(g []int, s []int) int {
	sort.Ints(g)
	sort.Ints(s)
	count := 0
	for i, j := 0, 0; i < len(s) && j < len(g); i++ {
		if s[i] >= g[j] {
			count++
			j++
		}
	}
	return count
}

// @lc code=end
