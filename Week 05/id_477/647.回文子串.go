package leetcode

/*
 * @lc app=leetcode.cn id=647 lang=golang
 *
 * [647] 回文子串
 */

// @lc code=start
func countSubstrings(s string) int {
	if len(s) == 0 {
		return 0
	}
	var res int
	for i := 0; i < len(s); i++ {
		res += countSubSeg(s, i, i)
		res += countSubSeg(s, i, i+1)
	}
	return res
}

func countSubSeg(s string, left, right int) int {
	var count int
	for left >= 0 && right < len(s) {
		if s[left] == s[right] {
			count++
			left--
			right++
		} else {
			break
		}
	}
	return count
}

// @lc code=end
