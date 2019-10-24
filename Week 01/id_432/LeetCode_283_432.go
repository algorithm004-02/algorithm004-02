package id_432

func moveZeroes(nums []int)  {
	notZeroIndex := 0
	for i := 0; i < len(nums) ; i++  {
		if nums[i] != 0 {
			nums[notZeroIndex] = nums[i]
			notZeroIndex++
		}
	}
	if notZeroIndex != 0 {
		for j := notZeroIndex; j < len(nums) ; j++   {
			nums[j] = 0
		}
	}
}
