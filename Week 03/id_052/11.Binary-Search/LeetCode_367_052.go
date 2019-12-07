package leetcode

func isPerfectSquare(num int) bool {
	low, high := 0, num
	for low <= high {
		mid := low + (high-low)/2
		if mid*mid < num {
			low = mid + 1
		} else if mid*mid > num {
			high = mid - 1
		} else {
			return true
		}
	}
	return false
}

func isPerfectSquareNewton(num int) bool {
	n := num
	for n*n > num {
		n = (n + num/n) / 2
	}
	if n*n == num {
		return true
	}
	return false
}
