package permutations

func permute(nums []int) [][]int {
	var res [][]int // 初始化结果
	permuteRec(nums, 0, &res)
	return res
}

// nums:当前的排列，开始下标start用于划分固定的元素，以及做全排列的子数组
func permuteRec(nums []int, start int, result *[][]int) {
	if start == len(nums) { // 当开始的start等于nums大小时
		tmp := make([]int, len(nums))
		copy(tmp, nums)
		*result = append(*result, tmp) // 说明start后已经没有做全排列的子数组了
		return
	}

	for i := start; i < len(nums); i++ { // 固定不同的元素到子数组第一个位置
		nums[i], nums[start] = nums[start], nums[i]
		permuteRec(nums, start+1, result)           // 递归的求从start+1开始的子数组全排列
		nums[i], nums[start] = nums[start], nums[i] // 递归结束把前面交换的两个元素交换回来
	}
}
