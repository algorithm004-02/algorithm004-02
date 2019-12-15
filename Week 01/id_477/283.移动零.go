package leetcode

/*
 * @lc app=leetcode.cn id=283 lang=golang
 *
 * [283] 移动零
 */

// @lc code=start
func moveZeroes(nums []int) {
	// j := 0
	// for i := 0; i < len(nums); i++ {
	// 	if nums[i] != 0 {
	// 		nums[j] = nums[i]
	// 		j++
	// 	}
	// }
	// for j < len(nums) {
	// 	nums[j] = 0
	// 	j++
	// }

	j := 0
	for i := 0; i < len(nums); i++ {
		if nums[i] != 0 {
			nums[j], nums[i] = nums[i], nums[j]
			j++
		}
	}
}

// @lc code=end
