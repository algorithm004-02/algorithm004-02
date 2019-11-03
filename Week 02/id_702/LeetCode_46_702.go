package leetcode

/*
 * @lc app=leetcode.cn id=46 lang=golang
 *
 * [46] 全排列
 */

// @lc code=start
func permute(nums []int) [][]int {
	if nums == nil {
		return nil
	}
	result := make([][]int, 0)
	permutestackback(&result, nums, 0)
	return result
}

func permutestackback(result *[][]int, nums []int, ind int) {
	if ind == len(nums) {
		tmp := make([]int, len(nums))
		copy(tmp, nums)
		*result = append(*result, tmp)
		return
	}
	for i := ind; i < len(nums); i++ {
		nums[i], nums[ind] = nums[ind], nums[i]
		permutestackback(result, nums, ind+1)
		nums[i], nums[ind] = nums[ind], nums[i]
	}
}

// @lc code=end
