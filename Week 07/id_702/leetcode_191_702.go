package leetcode

/*
 * @lc app=leetcode.cn id=191 lang=golang
 *
 * [191] 位1的个数
 */

// @lc code=start
func hammingWeight(num uint32) int {
	sum := 0
	for num != 0 {
		sum++
		num &= (num - 1)
	}
	return sum
}

// @lc code=end
