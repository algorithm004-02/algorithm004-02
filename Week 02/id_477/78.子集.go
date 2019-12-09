package leetcode

/*
 * @lc app=leetcode.cn id=78 lang=golang
 *
 * [78] 子集
 */

// @lc code=start

func subsets(nums []int) [][]int {
	if len(nums) == 0 {
		return nil
	}
	var res = make([][]int, 0)

	helperSubsets(&res, nums, []int{}, 0)
	return res
}

func helperSubsets(res *[][]int, nums, data []int, i int) {
	// terminal
	if i == len(nums) {
		tmp := make([]int, len(data))
		copy(tmp, data)
		*res = append(*res, tmp)
		return
	}
	// process
	helperSubsets(res, nums, data, i+1)
	helperSubsets(res, nums, append(data, nums[i]), i+1)
}

// @lc code=end
