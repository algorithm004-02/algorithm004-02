package leetcode

/*
 * @lc app=leetcode.cn id=231 lang=golang
 *
 * [231] 2的幂
 */

// @lc code=start
func isPowerOfTwo(n int) bool {
	// return n > 0 && (n&(n-1)) == 0
	if n <= 0 {
		return false
	}

	for {
		if n == 1 {
			return true
		}
		if n%2 == 1 {
			return false
		}
		n = n / 2
	}
	return false
}

// @lc code=end
