package main

func canJump(nums []int) bool {
	start, end := len(nums)-2, len(nums)-1
	for start >= 0 {

		if nums[start]+start >= end {
			end = start
		}
		start--
	}
	return end == 0
}
