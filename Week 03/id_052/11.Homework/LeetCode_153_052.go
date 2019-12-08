package leetcode

// Time: O(log(n)), Space: O(1)
func findMin(nums []int) int {
	low, high := 0, len(nums)-1 // 初始化游标为数组最下和最大下标
	for low < high {            // 只要low<high不断执行以下操作
		mid := low + (high-low)/2 // 获取mid
		if nums[mid] > nums[high] {
			low = mid + 1 // mid落在左边递增部分
		} else {
			high = mid // mid落在右边递增部分
		}
	}
	return nums[low]
}

// Time: O(log(n)), Space: O(1)
func findMinEarlyReturn(nums []int) int {
	low, high := 0, len(nums)-1
	for low < high {
		if nums[low] < nums[high] {
			return nums[low]
		}
		mid := low + (high-low)/2
		if nums[mid] > nums[high] {
			low = mid + 1
		} else {
			high = mid
		}
	}
	return nums[low]
}
