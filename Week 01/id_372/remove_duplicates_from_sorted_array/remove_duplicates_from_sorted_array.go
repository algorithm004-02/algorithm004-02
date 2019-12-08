package remove_duplicates_from_sorted_array

func removeDuplicates(nums []int) int {
	if len(nums) == 0 {
		return 0
	}

	i := 0
	for j := 1; j < len(nums); j++ {
		if nums[j] != nums[i] {
			i++
			nums[i] = nums[j]
		}
	}

	return i + 1
}

func removeDuplicatesV1(nums []int) int {
	numExist := make(map[int]bool, len(nums))

	nl := 0
	for i := 0; i < len(nums); i++ {
		if _, exist := numExist[nums[i]]; exist {
			continue
		}
		numExist[nums[i]] = true
		nums[nl] = nums[i]
		nl++
	}

	return nl
}
