package leetcode

/*
 * @lc app=leetcode.cn id=1 lang=golang
 *
 * [1] 两数之和
 */

// @lc code=start

func twoSum(nums []int, target int) []int {
	if nums == nil {
		return []int{}
	}
	dataMap := make(map[int]int, len(nums))
	for k, v := range nums {
		if _, ok := dataMap[target-v]; ok {
			return []int{dataMap[target-v], k}
		}
		dataMap[v] = k
	}
	return []int{}
}

// @lc code=end
