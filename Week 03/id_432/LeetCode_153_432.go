package id_432

func findMin(nums []int) int {
	if len(nums) == 1 {
		return nums[0]
	}
	left,right := 0,len(nums) - 1
	if nums[left] < nums[right] {
		return nums[left]
	}
	for right >= left {
		mid := left + (right - left) / 2;

		if nums[mid] > nums[mid + 1] {
			return nums[mid + 1];
		}

		if nums[mid - 1] > nums[mid] {
			return nums[mid]
		}

		if nums[mid] > nums[0] {
			left = mid + 1
		} else {
			right = mid - 1;
		}
	}
	return -1;
}