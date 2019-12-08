package leetcode

/*
 * @lc app=leetcode.cn id=66 lang=golang
 *
 * [66] 加一
 */

// @lc code=start
func plusOne(digits []int) []int {
	// carry := 1
	// for i := len(digits) - 1; i >= 0; i-- {
	// 	if carry > 0 {
	// 		sum := digits[i] + carry
	// 		carry = sum / 10
	// 		digits[i] = sum % 10
	// 	}
	// }
	// if carry > 0 {
	// 	res := make([]int, 0, len(digits)+1)
	// 	res = append(res, carry)
	// 	res = append(res, digits...)
	// 	digits = res
	// }
	// return digits

	for i := len(digits) - 1; i >= 0; i-- {
		digits[i]++
		digits[i] = digits[i] % 10
		if digits[i] != 0 {
			return digits
		}
	}
	if digits[0] == 0 {
		res := []int{1}
		res = append(res, digits...)
		digits = res
	}
	return digits
}

// @lc code=end
