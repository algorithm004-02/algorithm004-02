package leetcode

/*
 * @lc app=leetcode.cn id=191 lang=golang
 *
 * [191] 位1的个数
 */

// @lc code=start
func hammingWeight(num uint32) int {
	var count int
	for num > 0 {
		count++
		num = num & (num - 1)
	}
	return count
}

// @lc code=end
