package leetcode

/*
 * @lc app=leetcode.cn id=78 lang=golang
 *
 * [78] 子集
 */

// @lc code=start
func subsets(nums []int) [][]int {
	result := make([][]int, 0)
	tmp := make([]int, 0)
	subsetsbacktrack(&result, nums, 0, tmp)
	return result
}

func subsetsbacktrack(res *[][]int, nums []int, ind int, tmp []int) {
	if ind == len(nums) {
		a := make([]int, len(tmp))
		copy(a, tmp)
		*res = append(*res, a)
		return
	}

	subsetsbacktrack(res, nums, ind+1, tmp)
	tmp = append(tmp, nums[ind])
	subsetsbacktrack(res, nums, ind+1, tmp)
}

// @lc code=end
