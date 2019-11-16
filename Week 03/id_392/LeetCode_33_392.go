package main

func search(nums []int, target int) int {
	n := len(nums)
	l, r := 0, n
	var m int
	for l < r {
		m = l + (r-l)>>1
		if nums[m] == target {
			return m
		} else if nums[l] == target {
			return l
		} else if nums[r-1] == target {
			return r - 1
		}
		if nums[l] < nums[m] {
			if target > nums[m] || nums[l] > target {
				l = m + 1
			} else {
				r = m
			}
		} else {
			if nums[m] > target || target > nums[r-1] {
				r = m
			} else {
				l = m + 1
			}
		}
	}
	return -1
}
