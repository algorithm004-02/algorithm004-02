package sort

func selectionSort(nums []int) []int {
	for i := 0; i < len(nums); i++ {
		for j := i + 1; j < len(nums); j++ {
			if nums[j] < nums[i] {
				nums[i], nums[j] = nums[j], nums[i]
			}
		}
	}

	return nums
}

func bubbleSort(nums []int) []int {
	for i := 0; i < len(nums); i++ {
		for j := 0; j < len(nums)-1; j++ {
			if nums[j] > nums[j+1] {
				nums[j], nums[j+1] = nums[j+1], nums[j]
			}
		}
	}

	return nums
}

func insertionSort(nums []int) []int {
	for i := 0; i < len(nums)-1; i++ {
		for j := i + 1; j > 0; j-- {
			if nums[j] < nums[j-1] {
				nums[j], nums[j-1] = nums[j-1], nums[j]
			}
		}
	}

	return nums
}

func quickSort(nums []int, start, end int) {
	if start >= end {
		return
	}

	pivot := partition(nums, start, end)
	quickSort(nums, start, pivot-1)
	quickSort(nums, pivot+1, end)
}

func partition(nums []int, start, end int) int {
	pivot, counter := end, start
	for i := start; i < end; i++ {
		if nums[i] < nums[pivot] {
			nums[i], nums[counter] = nums[counter], nums[i]
			counter++
		}
	}
	nums[pivot], nums[counter] = nums[counter], nums[pivot]

	return counter
}

func mergeSort(nums []int, left, right int) {
	if left >= right {
		return
	}
	mid := left + (right-left)/2

	mergeSort(nums, left, mid)
	mergeSort(nums, mid+1, right)
	merge(nums, left, mid, right)
}

func merge(nums []int, left, mid, right int) {
	tmp := make([]int, right-left+1)
	i, j, k := left, mid+1, 0

	for i <= mid && j <= right {
		if nums[i] <= nums[j] {
			tmp[k] = nums[i]
			i++
			k++
		} else {
			tmp[k] = nums[j]
			j++
			k++
		}
	}

	for i <= mid {
		tmp[k] = nums[i]
		i++
		k++
	}

	for j <= right {
		tmp[k] = nums[j]
		j++
		k++
	}

	for p := 0; p < len(tmp); p++ {
		nums[left+p] = tmp[p]
	}
}
