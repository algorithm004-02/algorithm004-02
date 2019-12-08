/*
 * @lc app=leetcode.cn id=152 lang=golang
 *
 * [152] 乘积最大子序列
 */

// @lc code=start
func maxProduct(nums []int) int {
	var max *int
	imax, imin := 1, 1
	for _, v := range nums {
		if v < 0 {
			tmp := imax
			imax = imin
			imin = tmp
		}
		imax = compmax(imax*v, v)
		imin = compmin(imin*v, v)
		if max == nil {
			max = &imax
		}
		tmp := compmax(*max, imax)
		max = &tmp
	}
	return *max
}

func compmax(a, b int) int {
	if a >= b {
		return a
	}
	return b
}

func compmin(a, b int) int {
	if a <= b {
		return a
	}
	return b
}

// @lc code=end
