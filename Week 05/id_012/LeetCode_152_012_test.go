package main

func maxProduct(nums []int) int {
	var imax, imin, max int
	imax = 1
	imin = 1
	for k, v := range nums {
		if k == 0 {
			max = v
		}

		if v < 0 {
			imax, imin = imin, imax
		}

		if v*imax > v {
			imax = v * imax
		} else {
			imax = v
		}

		if v*imin < v {
			imin = v * imin
		} else {
			imin = v
		}

		if imax > max {
			max = imax
		}

	}
	return max
}
