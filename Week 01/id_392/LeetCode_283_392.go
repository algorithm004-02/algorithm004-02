package main

func moveZeroes(nums []int) {
	var tmp = 0
	for _, num := range nums {
		if num != 0 {
			nums[tmp] = num
			tmp++
		}
	}

	for i := tmp; i < len(nums); i++ {
		nums[i] = 0
	}
}
