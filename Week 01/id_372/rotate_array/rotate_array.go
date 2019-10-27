package rotate_array

func rotate(nums []int, k int) {
	//考虑k有可能大于len(nums)
	k = k % len(nums)

	arr := make([]int, 0, len(nums))
	arr = nums[len(nums)-k : len(nums)]
	for i := 0; i < len(nums)-k; i++ {
		arr = append(arr, nums[i])
	}

	for i := 0; i < len(nums); i++ {
		nums[i] = arr[i]
	}
}

func rotateV1(nums []int, k int) {
	if len(nums) <= 1 {
		return
	}
	//考虑k有可能大于len(nums)
	k = k % len(nums)

	for i := 0; i < k%len(nums); i++ {
		num := nums[len(nums)-1]
		for j := len(nums) - 2; j >= 0; j-- {
			nums[j+1] = nums[j]
		}
		nums[0] = num
	}
}

func rotateV2(nums []int, k int) {
	arr := make([]int, len(nums))

	for i := 0; i < len(nums); i++ {
		arr[(i+k)%len(nums)] = nums[i]
	}

	for i := 0; i < len(nums); i++ {
		nums[i] = arr[i]
	}
}
