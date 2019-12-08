/*
 * @lc app=leetcode.cn id=69 lang=golang
 *
 * [69] x 的平方根
 */

// @lc code=start
func mySqrt(x int) int {
	if x == 0 || x == 1 {
		return x
	}
	// 1. 二分查找
	// left, right := 1, x
	// for left <= right {
	// 	mid := left + (right-left)/2
	// 	if mid*mid == x {
	// 		return mid
	// 	} else if mid*mid > x {
	// 		right = mid - 1
	// 	} else {
	// 		left = mid + 1
	// 	}
	// }
	// return right

	// 2. 牛顿迭代
	a := x
	for a*a > x {
		a = (a + x/a) / 2
	}
	return a
}

// @lc code=end
