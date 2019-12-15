package leetcode

// 二分搜索法 Time: O(logn) Space: O(1)
func mySqrt(x int) int {
	low, high := 0, x
	for low <= high {
		mid := low + (high-low)/2
		mid2 := mid * mid
		if mid2 < x {
			low = mid + 1
		} else if mid2 > x {
			high = mid - 1
		} else {
			return mid
		}
	}
	return high
}

// 牛顿迭代法 Time: O(logn) Space: O(1)
func mySqrtNewton(x int) int {
	n := x
	for n*n > x {
		n = (n + x/n) / 2
	}
	return n
}
