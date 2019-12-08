package leetcode

import "sort"

/*
 * @lc app=leetcode.cn id=15 lang=golang
 *
 * [15] 三数之和
 */

// @lc code=start
func threeSum(nums []int) [][]int {
	res := make([][]int, 0)
	sort.Ints(nums)
	for k := 0; k < len(nums)-2; {
		if nums[k] > 0 {
			break
		}
		for i, j := k+1, len(nums)-1; i < j; {
			if nums[j] < 0 {
				break
			}
			sum := nums[k] + nums[i] + nums[j]
			if sum == 0 {
				res = append(res, []int{nums[k], nums[i], nums[j]})
				for i++; i < j && nums[i] == nums[i-1]; i++ {
				}
				for j--; i < j && nums[j] == nums[j+1]; j-- {
				}
			} else if sum < 0 {
				for i++; i < j && nums[i] == nums[i-1]; i++ {
				}
			} else {
				for j--; i < j && nums[j] == nums[j+1]; j-- {
				}
			}
		}
		for k++; k < len(nums)-2 && nums[k] == nums[k-1]; k++ {
		}
	}
	return res
}

// @lc code=end
