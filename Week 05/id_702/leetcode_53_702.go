package leetcode

/*
 * @lc app=leetcode.cn id=53 lang=golang
 *
 * [53] 最大子序和
 */

// @lc code=start
func maxSubArray(nums []int) int {
	if len(nums) == 0 {
		return 0
	}

	// 202/202 cases passed (8 ms)
	// Your runtime beats 78.64 % of golang submissions
	// Your memory usage beats 82.92 % of golang submissions (3.3 MB)
	cur := 0
	res := nums[0]
	for _, v := range nums {
		if cur < 0 {
			cur = v
		} else {
			cur += v
		}

		if cur > res {
			res = cur
		}
	}
	// 202/202 cases passed (12 ms)
	//Your runtime beats 18.17 % of golang submissions
	//Your memory usage beats 88.26 % of golang submissions (3.3 MB)
	//cur := 0
	//res := nums[0]
	//	for i := 0; i < len(nums); i++ {
	//		if cur < 0 {
	//			cur = nums[i]
	//		} else {
	//			cur += nums[i]
	//		}
	//
	//		if cur > res {
	//			res = cur
	//		}
	//	}

	return res
}

// @lc code=end
