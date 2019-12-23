package id_477

import "io"
// 冒泡
func bubbleSort(nums []int) {
	if len(nums) == 0 {
		return
	}
	for i := 0; i < len(nums)-1; i++ {
		for j := 0; j < len(nums)-1-i; j++ {
			if nums[j] > nums[j+1] {
				nums[j], nums[j+1] = nums[j+1], nums[j]
			}
		}
	}
}

// 选择
func selectSort(nums []int) {
	for i:=0;i<len(nums);i++{
		min:=i
		for j:=i;j<len(nums);j++{
			if nums[min]>nums[j]{
				min = j
			}
		}
		nums[min], nums[i] = nums[i], nums[min]
	}
}

// 插入
func insertSort(nums []int) {
	for i:=0;i<len(nums);i++{
		for j:=i;j>=0 && nums[j]<nums[j-1];j--{
			nums[j]=nums[j-1]
		}
		nums[j] = nums[i]
	}
}

func quickSort(nums []int, left, right int) int {
	pivot := nums[left]
	for left < right {
		for left < right && nums[left] <= pivot {
			left++
		}
		for left < right && nums[right] >= pivot {
			right--
		}
		nums[left], nums[right] = nums[right], nums[left]
	}
	nums[left] = pivot
	return left
}

func QuickSort(nums []int) {
	left, right := 0, len(nums)
	if right < 1 {
		return
	}
	quickSort(nums, left, right)
}

func MergeSort(array []int, left, right int) {
	if left >= right {
		return
	}
	mid := (left + right) >> 1
	MergeSort(array, left, mid)
	MergeSort(array, mid+1, right)
	merge(array, left, mid, right)
}

func merge(array []int, left, mid, right int) []int {
	i, j := left, mid+1
	res := []int{}
	for i <= mid && j <= right {
		if array[i] < array[j] {
			res = append(res, array[i])
			i++
		} else {
			res = append(res, array[j])
			j++
		}
	}
	for i <= mid {
		res = append(res, left[i])
		i++
	}
	for j <= right {
		res = append(res, right[j])
		j++
	}
	for 
	io.Copy(array[left:right], res)
}
