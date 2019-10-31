package leetcode

// Time: O(log(n)), Space: O(1)
func search(nums []int, target int) int {
	if nums == nil || len(nums) == 0 {
		return -1
	}
	low, high := 0, len(nums)-1 // 初始化游标low和high
	for low <= high {
		mid := low + (high-low)/2 // low和high中间下标mid
		if target == nums[mid] {  // 中间下标mid的值等于目标值
			return mid // 返回下标mid
		}
		if nums[mid] >= nums[low] { // mid落在左边的递增子数组
			if target < nums[mid] && target >= nums[low] {
				high = mid - 1 // 目标值在nums[low]和nums[mid]之间
			} else {
				low = mid + 1
			}
		} else { // mid落在旋转到右边的子数组
			if target > nums[mid] && target <= nums[high] {
				low = mid + 1 // 目标值在nums[mid]和nums[high]之间
			} else {
				high = mid - 1
			}
		}
	}
	return -1 // 循环结束后还没有找到目标值则返回-1
}
