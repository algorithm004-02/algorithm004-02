package leetcode

/*
 * @lc app=leetcode.cn id=50 lang=golang
 *
 * [50] Pow(x, n)
 */

// @lc code=start

func myPow(x float64, n int) float64 {
	if n == 0 {
		return 1.0
	}
	if n < 0 {
		x = 1 / x
		n = -1 * n
	}
	return helperMyPow(x, n)
}

func helperMyPow(x float64, n int) float64 {
	if n == 1 {
		return x
	}

	tmp := helperMyPow(x, n/2)
	if n%2 == 1 {
		return tmp * tmp * x
	} else {
		return tmp * tmp
	}
}

// @lc code=end
