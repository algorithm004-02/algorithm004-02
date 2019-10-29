package leetcode

/*
 * @lc app=leetcode.cn id=1 lang=golang
 *
 * [1] 两数之和
 */

// @lc code=start
func twoSum(nums []int, target int) []int {
	tgtMap := make(map[int]int)
	for i, num := range nums {
		if idx, ok := tgtMap[target-num]; ok {
			return []int{idx, i}
		}
		tgtMap[num] = i
	}
	return nil
}

// @lc code=end
