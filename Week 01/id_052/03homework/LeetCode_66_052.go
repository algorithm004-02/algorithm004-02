package LeetCode

func plusOne1(digits []int) []int {
	for i := len(digits) - 1; i >= 0; i-- {
		if digits[i] < 9 {
			// 当前位置不用进位，+1，然后直接返回
			digits[i]++
			return digits
		} else {
			// 要进位，当前位置置0
			digits[i] = 0
		}
	}
	return append([]int{1}, digits...)
}

// https://leetcode-cn.com/problems/plus-one/solution/custerxue-xi-bi-ji-by-custergo-7/
// 末位无进位，则末位加一即可，因为末位无进位，前面也不可能产生进位，比如 45 => 46
// 末位有进位，在中间位置进位停止，则需要找到进位的典型标志，即为当前位 %10 后为 0，则前一位加 1，直到不为 0 为止，比如 499 => 500
// 末位有进位，并且一直进位到最前方导致结果多出一位，对于这种情况，需要在第 2 种情况遍历结束的基础上，进行单独处理，比如 999 => 1000
func plusOne2(digits []int) []int {
	ll := len(digits)
	for i := ll - 1; i >= 0; i-- {
		digits[i]++
		digits[i] %= 10
		if digits[i] != 0 {
			return digits
		}
	}
	digits = append([]int{1}, digits...)
	return digits
}
