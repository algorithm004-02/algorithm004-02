package search_in_rotated_sorted_array

func search(nums []int, target int) int {
	for i := 0; i < len(nums); i++ {
		if nums[i] == target {
			return i
		}
	}
	return -1
}

func search1(nums []int, target int) int {
	if len(nums) == 0 {
		return -1
	}

	left, right := 0, len(nums)-1
	for left < right {
		mid := left + (right-left)/2
		if nums[mid] <= nums[right] {
			right = mid
		} else if nums[mid] > nums[right] && nums[mid] >= nums[left] {
			left = mid + 1
		}
	}
	//保存旋转点
	rotatePos := right

	left, right = 0, rotatePos-1
	for left <= right {
		mid := left + (right-left)/2
		if nums[mid] < target {
			left = mid + 1
		} else if nums[mid] > target {
			right = mid - 1
		} else {
			return mid
		}
	}

	left, right = rotatePos, len(nums)-1
	for left <= right {
		mid := left + (right-left)/2
		if nums[mid] < target {
			left = mid + 1
		} else if nums[mid] > target {
			right = mid - 1
		} else {
			return mid
		}
	}

	return -1
}

func search2(nums []int, target int) int {
	if len(nums) == 0 {
		return -1
	}

	left, right := 0, len(nums)-1
	for left <= right {
		mid := left + (right-left)/2
		if nums[mid] == target {
			return mid
		}

		if (nums[mid] > nums[0] && target >= nums[0] && target <= nums[mid]) || (nums[mid] < nums[0] && (target <= nums[mid] || target >= nums[0])) {
			right = mid - 1
		} else {
			left = mid + 1
		}
	}

	return -1
}
