package leetcode

/*
 * @lc app=leetcode.cn id=70 lang=golang
 *
 * [70] 爬楼梯
 */

// @lc code=start
func climbStairs(n int) int {
	if n <= 2 {
		return n
	}
	var s1, s2 = 1, 2
	for n > 2 {
		tmp := s1 + s2
		s1 = s2
		s2 = tmp
		n--
	}
	return s2
}

// @lc code=end
