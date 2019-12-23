package leetcode

/*
 * @lc app=leetcode.cn id=338 lang=golang
 *
 * [338] 比特位计数
 */

// @lc code=start
func countBits(num int) []int {
	var ans = make([]int, num+1)
	for i := 1; i <= num; i++ {
		ans[i] = ans[i>>1] + i&1
		// ans[i] = ans[i&(i-1)] + 1
	}
	return ans
}

// @lc code=end
